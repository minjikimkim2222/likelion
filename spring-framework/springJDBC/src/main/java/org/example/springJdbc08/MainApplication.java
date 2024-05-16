package org.example.springJdbc08;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao){
        return args -> {
          User user = new User();
          user.setName("hihi");
          user.setEmail("hihi@exam.com");

          User insertNewUser = userDao.insertUser(user);
            System.out.println(insertNewUser.getId());
        };
    }
}
