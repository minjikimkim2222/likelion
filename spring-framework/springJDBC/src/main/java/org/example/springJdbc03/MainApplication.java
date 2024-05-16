package org.example.springJdbc03;

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
    public CommandLineRunner demo(UserService userService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 실제 실행코드는 CommandLineRunner에서..
                try {
                    userService.executeComplexBusinessProcess("minjiki2", "normal@exam.com");
                    // normal@exam.com이 insert된 후, 에러에 걸리지 않아서.. , "updated.email@example.com  까지 하나의 트랜잭션 commit !!
                    userService.executeComplexBusinessProcess("kim","error@exam.com");
                    // 일부로 에러 발생시킨다면, kim / error@exam.com insert를 시켰다가,
                    // email에 "error"문자열이 포함되어 있어서, 에러 발생 !!!
                    // 그래서 update까지도 못가고 insert시킨 부분까지 롤백되어 취소 ! (하나의 트랜잭션 롤백..)
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        };
    }
}
