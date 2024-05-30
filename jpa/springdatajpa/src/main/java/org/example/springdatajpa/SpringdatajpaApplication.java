package org.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringdatajpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository){
        return args -> {
            // create new user
            User newUser = new User("minjiki2", "minjiki2@example.com");
            userRepository.save(newUser);
            log.info("User added : " + newUser.getName());
        };
    }

}
