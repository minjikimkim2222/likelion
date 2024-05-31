package org.example.springdatajpa4;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class Springdatajpa04Application {
    public static void main(String[] args) {
        SpringApplication.run(Springdatajpa04Application.class);
    }

    @Bean
    CommandLineRunner demo(UserRepositoryCustom userRepository){
        return args -> {
            // Criteria API를 사용한 사용자 조회 예제
            List<User> usersByNameCriteria = userRepository.findUsersByName("홍길동");
            usersByNameCriteria.forEach(user -> log.info("Criteria API로 찾은 사용자: " + user.getName() + ", 이메일: " + user.getEmail()));

            List<User> list = userRepository.findUsersDynamically("홍길동", "hong@example.com");
            list.forEach(user -> log.info("Criteria API로 동적으로 찾은 사용자: " + user.getName() + ", 이메일: " + user.getEmail()));
        };
    }
}
