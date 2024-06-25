package org.filterTest.filterexam.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 필터는 어떤 요청을 처리하기 전, 해야할일을 걸러줄 수 있다.
// HTTP 요청 -> WAS -> '필터' -> 서블릿 -> 컨트롤러
// '필터'에서 인증/인가를 먼저 처리를 한후, 서블릿으로 가서 모든 요청이 처리될 수 있도록 할 수 있음.
@Slf4j
@WebFilter(urlPatterns = {"/hi"})
public class FirstFilter implements Filter {

    public FirstFilter() {
        log.info("#### FirstFilter 생성자() 실행 ####");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("#### FirstFilter init 메서드 실행 ####");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("#### #### FirstFilter doFilter 메서드 실행 전 ####");

        // 이부분 중요!
        // 만약 다음필터가 있다면 필터호출, 없으면 서블릿 호출
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("#### #### FirstFilter doFilter 메서드 실행 후 ####");
    }

    @Override
    public void destroy() {
        log.info("#### #### FirstFilter destroy 메서드 실행 ####");
    }
}
