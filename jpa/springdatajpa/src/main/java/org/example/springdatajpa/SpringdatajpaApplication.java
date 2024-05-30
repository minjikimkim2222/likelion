package org.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
@Slf4j
public class SpringdatajpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository){
        return args -> {
//            // create new user
//            User newUser = new User("minjiki2", "minjiki2@example.com");
//            userRepository.save(newUser);
//            log.info("User added : " + newUser.getName());
//
//            // delete user
//
//            User deleteUser = userRepository.findById(2L).orElse(null);
//            userRepository.delete(deleteUser);
//            log.info("User deleted : " + deleteUser.getName());

//            User testUser = new User("minjiki2", "test@exam.com");
//            userRepository.save(testUser);

       //     userRepository.updateUserEmail(3L, "new@exam.com");
        };
    }

}
