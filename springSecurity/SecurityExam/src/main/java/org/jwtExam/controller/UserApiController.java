package org.jwtExam.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jwtExam.domain.RefreshToken;
import org.jwtExam.domain.Role;
import org.jwtExam.domain.User;
import org.jwtExam.dto.UserLoginResponseDto;
import org.jwtExam.jwt.util.JwtTokenizer;
import org.jwtExam.security.dto.UserLoginDto;
import org.jwtExam.service.RefreshTokenService;
import org.jwtExam.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLoginDto userLoginDto, BindingResult bindingResult
        , HttpServletResponse httpServletResponse){
        // username, password가 null일 때 (정해진 형식과 맞지 않을 때)
        if (bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        // 일단은 username과 password값을 잘 받아왔다면..
        // 우리 서비스에 가입한 사용자가 있는지..
        User user = userService.findByUsername(userLoginDto.getUsername());
        // '요청정보에서' 얻어온 비밀번호와 '우리 서비스가 갖고있는' 비밀번호가 일치하는지 확인
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())){
            // 일치하지 않다면,, 로그인 실패
            return new ResponseEntity("비밀번호가 올바르지 않습니다.", HttpStatus.UNAUTHORIZED);
        }

        // 여기까지 왔다는 건, 유저도 있고, 비밀번호도 맞다.
        // 토큰 발급을 위해, role 객체를 꺼내서, 롤의 이름만 리스트로 받아온다.
        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());

        // 토큰 발급
        String accessToken = jwtTokenizer.createAccessToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);
        String refreshToken = jwtTokenizer.createRefreshToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);

        // 생성된 RefreshToken만 데이터베이스에 저장 -- '서버'에 저장
        // (후에 클라이언트에서 만료된 AccessToken 요청이 들어온다면, 클라이언트 쿠키에 있는 RefreshToken과 서버의 RefreshToken 비교를 위해..)
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setValue(refreshToken);
        refreshTokenEntity.setUserId(user.getId());

        refreshTokenService.addRefreshToken(refreshTokenEntity);

        // AccessToken과 RefreshToken을 클라이언트에 반환하고, 각각의 토큰을 쿠키로 설정해, 클라이언트에게 전송함
        UserLoginResponseDto loginResponseDto = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();

        Cookie accessTokenCookie = new Cookie("accessToken", accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRE_COUNT / 1000)); // -- 30분

        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        // refreshTokenCookie.setSecure(true); -- HTTPS 쓰면 사용하세요
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.REFRESH_TOKEN_EXPIRE_COUNT / 1000)); // -- 7 days

        httpServletResponse.addCookie(accessTokenCookie);
        httpServletResponse.addCookie(refreshTokenCookie);

        return new ResponseEntity(loginResponseDto, HttpStatus.OK);
    }
}
