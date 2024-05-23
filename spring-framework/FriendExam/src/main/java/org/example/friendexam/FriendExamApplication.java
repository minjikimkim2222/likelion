package org.example.friendexam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.example.friendexam.repository.FriendRepository;

@SpringBootApplication
public class FriendExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendExamApplication.class, args);
        // 실제 테스트 코드는 CommandLineRunner에서..
    }
//
//    @Bean
//    public CommandLineRunner run(FriendRepository repository){
//        return args -> {
//            repository.findAll().forEach(s -> System.out.println(s));
//        };
//    }

}
