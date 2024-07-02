package org.jwtExam.config;

import lombok.RequiredArgsConstructor;
import org.jwtExam.jwt.exception.CustomAuthenticationiEntryPoint;
import org.jwtExam.jwt.filter.JwtAuthenticationFilter;
import org.jwtExam.jwt.util.JwtTokenizer;
import org.jwtExam.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/*
   JWT를 이용한 로그인 설정
 */
@Configuration
@EnableWebSecurity // -- Security 관련 설정임을 알리기 위해 넣은 어노테이션
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthenticationiEntryPoint customAuthenticationiEntryPoint;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/userregform", "/userreg", "/", "/login", "refreshToken").permitAll() // -- 회원가입,로그인 페이지는 모두 다 접근 가능
                        .anyRequest().authenticated() // -- 모든 request에 대해서 '인증' 요구 !
                )
                // -- 우리가 설정한 필터가 적용이 될 것 !!
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenizer), UsernamePasswordAuthenticationFilter.class)
              //  .formLogin(Customizer.withDefaults()) // 폼로그인 처리 - 스프링 시큐리티가 제공해주는 기본 설정 사용
                .formLogin(form -> form.disable()) // 폼로그인 사용 X -- 대신 JWT 토큰 인증 사용할 것
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                    httpSecuritySessionManagementConfigurer
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 X (JWT 토큰 인증사용할 것)
                )
                .csrf(csrf -> csrf.disable()) // -- csrf 보호 비활성화 (폼데이터를 받기 위해서 추가해줘야 함 !!)
                .httpBasic(httpSecurityHttpBasicConfigurer ->
                        httpSecurityHttpBasicConfigurer.disable()
                )
                .cors(cors -> cors.configurationSource(configurationSource())) // CORS 설정 (API로 접근했을 때, 어디까지 허용할래?)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(customAuthenticationiEntryPoint)); // 예외핸들러 설정

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public CorsConfigurationSource configurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.addAllowedMethod("*"); // 메서드가 뭘 요청하더라도 들어줌..
        config.addAllowedHeader("*");
        config.setAllowedMethods(List.of("GET", "POST", "DELETE", "PATCH", "PUT")); // -- 해당 메서드 허용

        source.registerCorsConfiguration("/**", config); // -- 모든 url 요청에 대해, 다음 설정을 허용

        return source;
    }

}
