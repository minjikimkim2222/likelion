package org.filterTest.filterexam;

import jakarta.servlet.Filter;
import org.filterTest.filterexam.filter.FirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>();

        // 등록할 필터 지정
        filterFilterRegistrationBean.setFilter(new FirstFilter());

        // 필터는 체인으로 동작함. 따라서 우선순위 설정 필요
        filterFilterRegistrationBean.setOrder(1);

        // 필터를 적용할 URL 패턴 -- /hi만 적용
        filterFilterRegistrationBean.addUrlPatterns("/hi");

        return filterFilterRegistrationBean;
    }
}
