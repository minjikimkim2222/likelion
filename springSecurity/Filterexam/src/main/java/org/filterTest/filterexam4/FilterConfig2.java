package org.filterTest.filterexam4;

import jakarta.servlet.Filter;
import org.filterTest.filterexam4.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig2 {
    @Bean
    public FilterRegistrationBean saveUserContext(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setFilter(new AuthenticationFilter());

        filterFilterRegistrationBean.setOrder(1);

        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }
}
