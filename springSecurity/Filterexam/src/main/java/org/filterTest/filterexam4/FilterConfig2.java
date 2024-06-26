package org.filterTest.filterexam4;

import jakarta.servlet.Filter;
import org.filterTest.filterexam4.filter.AuthenticationFilter;
import org.filterTest.filterexam4.service.UserService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig2 {
    @Bean
    public FilterRegistrationBean saveUserContext(UserService userService){ // userservice의 findByusername
        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setFilter(new AuthenticationFilter(userService)); // userservice 주입 추가 !!

        filterFilterRegistrationBean.setOrder(1);

        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}
