package org.filterTest.filterexam4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.filterTest.filterexam4.entity.User;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

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

            // 찾은 쿠키값을 ThreadLocal 에 저장해주면, 편하게 쓸 수 있겠다 !!
            User user = new User();
            user.setUsername(auth); // "minjiki2" or null

            UserContext.setUser(user);

            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.clear();
        }
    }
}
