package org.zizonsecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.zizonsecurity.security.CustomUserDetailsService;

/*
    SecurityFilterChain - 인증/인가 를 위한 로직 구현

    인증 관련 설정
        - authorizeHttpRequests

    인가 관련 설정
        - requestMatchaers
            -> 상식적으로 회원가입 페이지는 모두 접근가능하게 해야지, 회원가입하고 나서, 로그인되겠지요 !
 */
@Configuration
@EnableWebSecurity // -- Security 관련 설정임을 알리기 위해 넣은 어노테이션
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/userregform", "/userreg", "/").permitAll() // -- 회원가입 페이지는 모두 다 접근 가능
                        .anyRequest().authenticated() // -- 모든 request에 대해서 '인증' 요구 !
                )
              //  .formLogin(Customizer.withDefaults()) // 폼로그인 처리 - 스프링 시큐리티가 제공해주는 기본 설정 사용
                .userDetailsService(customUserDetailsService)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/userregform", "/userreg", "/loginform", "/login")) // -- csrf 보호 비활성화 (폼데이터를 받기 위해서 추가해줘야 함 !!)
                // (csrf를 비활성화하면, 클라이언트에서 서버로의 요청이 csrf 토큰 없이도 처리된다.)
                .formLogin(form -> form
                        .loginPage("/loginform") // 사용자 정의 로그인 페이지
                        .loginProcessingUrl("/login") // 로그인 폼 액션 URL
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/welcome"); // 로그인성공후, redirect할 페이지
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 URL
                        .logoutSuccessUrl("/") // 로그아웃 성공 후, 리다이렉션할 URL
                        .permitAll()
                )
                .sessionManagement(sessionManagment -> sessionManagment
                        .maximumSessions(1) // -- 세션 허용 개수 (동시 접속 허용 개수)
                        .maxSessionsPreventsLogin(true) // -- 동시 로그인 차단
                        /*
                            default (false) - 먼저 로그인한 사용자 차단
                            true - 두번째 로그인한 사용자 차단 (허용개수에 따라 다름, 나중에 로그인한 사용자 차단)
                         */
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
