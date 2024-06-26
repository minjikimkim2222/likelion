package org.filterTest.filterexam4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.filterTest.filterexam4.entity.User;
import org.filterTest.filterexam4.service.UserService;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter implements Filter {

    private final UserService userService; // 생성자 주입 - FilterConfig2에서도 주입 !!
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        String auth = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")){
                    auth = cookie.getValue();
                    break; // 쿠키값("minjiki2")를 받아서 auth 에 저장 !
                }
            }
        }

        try {
            // 인증된 사용자라면..
            if (auth != null) {
                log.info("너 여기는 오니?");
                // 찾은 쿠키값을 ThreadLocal 에 저장해주면, 편하게 쓸 수 있겠다 !!

                // 요청 url에 따라서 http://localhost:8080/admin -- Role의 ROLE_ADMIN 사용자에게만 인가되도록
                String requestURI = request.getRequestURI();
                log.info("requestURI : {}", requestURI);

                User founduser = userService.findByUsername(auth);
                log.info("user : {}", founduser);

                if (founduser != null) {
                    if (requestURI.equals("/admin") && founduser.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))
                    ||  (requestURI.equals("/welcome") && founduser.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN")))){
                        // ROLE_ADMIN 사용자임
                        filterChain.doFilter(servletRequest, servletResponse);
                        UserContext.clear();
                        return ;
                    }
                }

                // 권한이 없는 사용자
                if (requestURI.equals("/admin")  || requestURI.equals("/welcome")){
                    response.sendRedirect("/access-denied");
                }


            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.clear();
        }
    }
}
