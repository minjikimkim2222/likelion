package aopExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopExamApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AopExamApplication.class, args);
    }

    @Autowired
    SimpleService service;
    @Override
    public void run(String... args) throws Exception {
        // service가 불렸을 때 어떻게 동작.?
        System.out.println("run test !!!");
        System.out.println(service.doSomething());

        // 메서드 추가한 거 실행 추가
        service.hungry();

        // ->> AfterReturning 테스트

        // setFood 테스트
        service.setFood("플레인 크로플");


    }
}
