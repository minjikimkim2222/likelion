package org.filterTest.filterexam2;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 사용자가 요청할 때 보낸 값이 있다면, 추출해서 UserContext에다가 저장하는 로직
        try {
            User user = new User();
            user.setUsername("minjiki2");
            user.setPassword("1234");

            UserContext.setUser(user); // UserContext에 값을 저장했을 때..

            // 이 로직 필수라고 했다!!
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.clear(); // 쓰레드풀을 사용하므로, 기존에 사용되었던 쓰레드를 또 쓸 수 있으니, clear !!
        }
    }
}
