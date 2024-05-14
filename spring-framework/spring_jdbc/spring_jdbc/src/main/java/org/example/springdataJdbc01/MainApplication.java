package org.example.springdataJdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        // 스프링 어플리케이션 실행..
        // 테스트하고 싶을 때 -- CommandLineRunner..
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository){ // 필요한 객체 의존성 주입..(UserRepository)
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 실제 테스트 코드.. - insert
                // userRepository.save(new User("save1", "save1@exam.com"));

                // select
                Iterable<User> users = userRepository.findAll();
                for (User user : users){
                    System.out.println(user.getId() + ", " + user.getName() + ", " + user.getEmail());
                }

                // findById

                User user = userRepository.findById(11L).get();
                System.out.println(user.getName() + ", " + user.getEmail());

                //userRepository.save(new User("uniqueName", "unique@exam.com"));
                User userOne = userRepository.findByName("uniqueName");
                System.out.println(userOne.getName() + ", " + userOne.getEmail());

//                List<User> usersAll = userRepository.findAllByName("insertTest");
//                for (User userA : usersAll){
//                    System.out.println(userA.getId() + " , " + userA.getEmail());
//                }

            }
        };
    }
}
