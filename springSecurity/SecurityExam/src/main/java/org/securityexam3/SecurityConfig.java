package org.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/shop/**", "/test").permitAll() // 특정 경로는 인증 없이 접근 허용
                                .requestMatchers("/user/mypage").hasRole("USER") // USER의 role 사용자만 해당 페이지 접근 허용
                                /* 인가순서는 순서대로 적용되기에, 보다 구체적인 url을 먼저 작성한다. */
                                .requestMatchers("/admin/abc").hasRole("ADMIN")
                                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERUSER")
                                .anyRequest().authenticated() // 나머지 모든 요청은 인증 요구
                )
                .formLogin(Customizer.withDefaults()); // 폼로그인 처리 - 스프링 시큐리티가 제공해주는 기본 설정 사용

        return http.build();
    }

    // 빈 추가

    @Bean
    public PasswordEncoder passwordEncoder(){ // 유저 password 인코딩 (password가 암호화됨)
        return new BCryptPasswordEncoder();
    }

    // UserDetailsService에서 각 유저의 ID와 원본 비밀번호를 설정할 때, password 빈을 통해 비밀번호를 암호화
    @Bean
    public UserDetailsService userDetailsService(){
        // 실제 프로젝트에서는 이부분을, 우리 DB에 있는 사용자 정보를 이용할 수 있도록 코드를 짤 것
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails superuser = User.withUsername("superuser")
                .password(passwordEncoder().encode("1234"))
                .roles("SUPERUSER")
                .build();

        UserDetails minjiki2 = User.withUsername("minjiki2")
                .password(passwordEncoder().encode("1234"))
                .roles("USER", "ADMIN") /* 한 유저에 여러 개의 권한을 가지게 할수도 있다.*/
                .build();

        return new InMemoryUserDetailsManager(user, admin, superuser, minjiki2);
        // id, pw, role을 가진 여러개의 유저정보를, InMemoryUserDetailsManager에 등록한다 !!
    }

}
