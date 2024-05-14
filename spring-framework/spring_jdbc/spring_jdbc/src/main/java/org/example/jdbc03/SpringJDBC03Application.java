package org.example.jdbc03;

import org.example.jdbc03.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringJDBC03Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC03Application.class, args);
        // main에서 스프링어플리케이션 동작시키고..
        // 실질적인 테스트 코드는 CommandLineRunner !!
    }

    @Bean
    public CommandLineRunner demo2(UserDao userDao){ // 쓰고 싶은 객체를 쓰려면, injection 해줘야지요..
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // insert test
                // userDao.insertUser(new User(null,"insertTest", "insertTest@exam.com"));

                // findAllUsers test
                List<User> users = userDao.findAllUsers();
                users.forEach(user -> System.out.println(user.getId() + ", " + user.getName() + ", " + user.getEmail()));

                // update test
                //userDao.updateUserEmail("insertTest", "update@exam.com");


                // delete test
                userDao.deleteUser("kim"); // 일부로 예외 만들어서 제대로 되는지 테스트..
            }
        };
    }
}