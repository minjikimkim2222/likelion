package org.jwtExam.security;

import lombok.RequiredArgsConstructor;
import org.jwtExam.domain.User;
import org.jwtExam.repository.UserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
    package 3의 SecurityConfig에서 UserDetailsService처럼,
    해당 인터페이스를 구현하는 클래스.

    CustomUserDetailsService의 역할 : 스프링 시큐리티에 등록할 유저 정보 등록 !
        - 데이터베이스에 저장된 사용자정보를 기반으로, "스프링시큐리티에서 요구하는", UserDetails 객체를 생성해 반환해주는 역할

    스프링시큐리티 동작 예시
        1. 로그인 시도 시, 스프링 시큐리티는 loadUserByUsername 메서드를 호출해서, form에서 입력한 사용자 이름에 대한 조회!!
            -> 이때 필요한 것을 여기서 구현한 것

        2. 데이터베이스에서 사용자 정보를 찾고, 이를 기반으로 UserDetails 객체 생성

        3. 생성된 UserDetails 객체를 통해, 스프링 시큐리티는 입력된 비밀번호와 데이터베이스에 저장된 암호화된 비밀번호를 비교해,
            '인증' 및 '인가' 수행 가능 !!
            -> 이때 필요한 코드를 SecurityConfig에 구현할 것 !!
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository; // 생성자 주입 DI
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found with username : " + username);
        }

        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new)); // role이 여러개니까, role의 name을 뽑아와서 string 배열로!

        return userBuilder.build();
    }
}
