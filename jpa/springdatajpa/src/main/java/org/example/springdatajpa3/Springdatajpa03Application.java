package org.example.springdatajpa3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class Springdatajpa03Application {
    public static void main(String[] args) {
        SpringApplication.run(Springdatajpa03Application.class);
    }

    @Bean
    CommandLineRunner demo(UserRepositoryNativeQuery userRepositoryNativeQuery){
        return args -> {
            // 네이티브 SQL을 이용한 사용자 조회
            List<User> usersByEmail = userRepositoryNativeQuery.findByEmailNative("example");
            usersByEmail.forEach(user -> log.info("이메일로 찾은 사용자 : " + user));

            // 네이티브 쿼리를 사용해, 일부 칼럼을 조회하고 + "DTO" 반환 예제
            List<Object[]> usersByName = userRepositoryNativeQuery.findUserByNameNative("홍");

            List<UserDto> userDtos = usersByName.stream()
                    .map(result -> new UserDto((String) result[0], (String) result[1]))
                    .collect(Collectors.toList());

            userDtos.forEach(userDto ->
            {
                log.info("이름으로 찾은 사용자 : " + userDto.getName() + ", 이메일 : " + userDto.getEmail());
            });
        };
    }
}
