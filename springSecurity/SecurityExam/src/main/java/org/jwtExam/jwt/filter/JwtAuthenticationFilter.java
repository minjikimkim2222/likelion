package org.jwtExam.jwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jwtExam.jwt.exception.JwtExceptionCode;
import org.jwtExam.jwt.token.JwtAuthenticationToken;
import org.jwtExam.jwt.util.JwtTokenizer;
import org.jwtExam.security.CustomUserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    - 스프링시큐리티에서 JWT기반인증을 처리하기 위해 사용되는 커스텀 필터

    - 필터내에서 할일
        1. JWT 추출 : 요청헤더에서 JWT 추출
        2. JWT 검증 : 추출한 JWT 유효성 검증
        3. 인증 컨텍스트 설정 : JWT가 유효한 경우, 인증된 사용자의 정보를, 스프링시큐리티컨텍스트에 설정
        4. 요청 처리 계속 진행 : 필터체인의 다음 필터로 요청을 전달하여, 나머지 보안처리와 어플리케이션 로직이 정상적으로 실행되도록.
 */
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenizer jwtTokenizer;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request); // accessToken value 받아옴

        if(StringUtils.hasText(token)){
            try{
                getAuthentication(token);

            }catch (ExpiredJwtException e){
                // 예외가 발생했을 때, 예외 상세정보를 ("exception", value)로 저장해서, 이후 예외처리로직에서 사용할 수 있게끔.
                request.setAttribute("exception", JwtExceptionCode.EXPIRED_TOKEN.getCode());
                log.error("Expired Token : {}",token,e);
                throw new BadCredentialsException("Expired token exception", e);
            }catch (UnsupportedJwtException e){
                request.setAttribute("exception", JwtExceptionCode.UNSUPPORTED_TOKEN.getCode());
                log.error("Unsupported Token: {}", token, e);
                throw new BadCredentialsException("Unsupported token exception", e);
            } catch (MalformedJwtException e) {
                request.setAttribute("exception", JwtExceptionCode.INVALID_TOKEN.getCode());
                log.error("Invalid Token: {}", token, e);
                throw new BadCredentialsException("Invalid token exception", e);
            } catch (IllegalArgumentException e) {
                request.setAttribute("exception", JwtExceptionCode.NOT_FOUND_TOKEN.getCode());
                log.error("Token not found: {}", token, e);
                throw new BadCredentialsException("Token not found exception", e);
            } catch (Exception e) {
                log.error("JWT Filter - Internal Error: {}", token, e);
                throw new BadCredentialsException("JWT filter internal exception", e);
            }
        }

        // 예외 다 통과하면, 다음필터 존재하면 필터를, 아니면 컨트롤러 이어서..
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");

        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    private void getAuthentication(String token){
        Claims claims = jwtTokenizer.parseAccessToken(token);

        // 파싱된 claims로부터 유저 정보 꺼내기
        String email = claims.getSubject();
        Long userId = claims.get("userId", Long.class);
        String name = claims.get("name", String.class);
        String username = claims.get("username", String.class);

        List<GrantedAuthority> authorities = getGrantedAuthorities(claims);

        // CustomUserDetails 객체를 구현해, claims로부터 뽑은 정보를 해당 객체에 저장
        CustomUserDetails userDetails = new CustomUserDetails(username,"",name,authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        // JwtAuthenticationToken 객체 구현해, 해당 객체 저장
        Authentication authentication = new JwtAuthenticationToken(authorities,userDetails,null);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // 사용자 권한을 뽑아내주는 객체
    private List<GrantedAuthority> getGrantedAuthorities(Claims claims){
        List<String> roles = (List<String>)claims.get("roles");

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles){
            authorities.add(()->role);
        }

        return authorities;
    }
}
