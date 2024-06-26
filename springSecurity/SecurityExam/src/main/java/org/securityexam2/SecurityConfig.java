package org.securityexam2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequest ->  authorizeRequest.
                        anyRequest(). // 모든 요청에 대해서
                        authenticated() // 인증 요구
                )
                .formLogin(Customizer.withDefaults()); // 폼로그인처리 - 스프링 시큐리티가 제공해주는 기본적인 설정 사용

        // Remember-me 쿠키
        http
                .rememberMe(rememberme ->  rememberme
                        .rememberMeParameter("remember")
                        .tokenValiditySeconds(300)
                );
        return http.build();
    }

}
