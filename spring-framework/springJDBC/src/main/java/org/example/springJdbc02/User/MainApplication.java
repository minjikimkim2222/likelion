package org.example.springJdbc02.User;

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
            try {
                // 정상적으로 실행되는지 확인 (insert와 update 모두에 문제가 없고, @Transactional 설정이 제대로 되어있을 때..)
                //userDao.createAndUpdateUser("transactionTEST1", "trans@email.com", "trans@newEmail.com");

                // 일부로 에러 발생
                userDao.createAndUpdateUser("transactionTEST2", "trans@email.com", "error@email.com");
            } catch (Exception e){
                System.out.println("트랜잭션 도중에 일부로 에러 발생시키기.. " + e.getMessage());
            }

        };
    }
}
