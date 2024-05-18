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
    SimpleService service; // SimpleService 이미 @Service로 Bean 등록되어있으니, 필드로 의존성 주입이 가능한 것!
    @Override
    public void run(String... args) throws Exception {
        // service가 불렸을 때 어떻게 동작.?
        System.out.println("AopExamApplication run() run...");
        System.out.println(service.doSomething());

        // 메서드 추가한 거 실행 추가
        service.hungry();
        service.setFood("오이 닭가슴살 포케", 1);

        // 예외발생 메서드 실행..
        try {
            service.simpleError();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}
