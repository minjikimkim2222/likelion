package org.securityexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
                );
              //  .formLogin(Customizer.withDefaults()); // 폼로그인처리 - 스프링 시큐리티가 제공해주는 기본적인 설정 사용

        // 1. 인증관련설정 !!
        http
                .formLogin(formLogin -> formLogin
                   //     .loginPage("/loginForm") // 사용자지정 로그인 페이지
                        .defaultSuccessUrl("/success")
                        .failureUrl("/fail")
                                .successHandler(((request, response, authentication) -> {
                                    log.info("authentication : {}", authentication.getName());
                                    log.info("authentication22 : {}", authentication.getAuthorities());
                                    response.sendRedirect("/success"); // -- 로그인 성공한후 할일을 successHandler에!
                                    // 인증이 실행된후, 해당 인증에 대한 정보를 authentication라는 객체에 담아줌.
                                }))
                                .failureHandler(((request, response, exception) -> {
                                    log.info("exception :: {}", exception.getMessage());
                                    response.sendRedirect("/login"); // -- 로그인실패 후 할 일
                                }))
//                        .usernameParameter("userId") // 로그인폼에서 사용자이름(아이디) 필드의 파라미터 이름 설정
//                        .passwordParameter("passwd")
//                        .loginProcessingUrl("/login-processing") // 로그인폼제출URL. 이 URL로 POST 요청이 오면, 인증 처리
                        .permitAll() // loginPage에 대한 요청은 누구나 요청할 수 있도록
                );

        // 로그아웃 설정 지정
        http
                .logout(logout -> logout
                        .logoutUrl("log_out")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            log.info("logout >>> ");

                            request.getSession().invalidate(); // -- 세션 무효화
                        })
                        .addLogoutHandler((request, response, authentication) -> {
                            log.info("add logout handler, 세션 무효화 이외의 복잡한 코드 작성 ..");
                        })
                        .deleteCookies("remember-me")
                );

        return http.build();
    }

}
