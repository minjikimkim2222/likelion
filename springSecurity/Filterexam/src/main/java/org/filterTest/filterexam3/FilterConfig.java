//package org.filterTest.filterexam3;
//
//import jakarta.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean saveUserContext(){
//        FilterRegistrationBean<Filter> filterFilterRegistrationBean =
//                new FilterRegistrationBean<>();
//
//        filterFilterRegistrationBean.setFilter(new SaveUserContextFilter());
//
//        filterFilterRegistrationBean.setOrder(1);
//
//        // 모든 request 요청에 대해서, 각자의 UserContext 설정을 저장할 것 !!
//        // 그러고 나면 info에서 해당 인증,인가에 대한 요청사용가능!
//        filterFilterRegistrationBean.addUrlPatterns("/*");
//
//        return filterFilterRegistrationBean;
//    }
//}
