package org.example.springJdbc06;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        // CommandLineRunner bean에다가 실행코드..
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao){ // 이미 빈으로 등록한 UserDao(@Repository)를 injection 받기..
        return args -> {
            userDao.insertUser(new User(null, "insertTest", "insertTest@email.com"));
        };
    }
}
