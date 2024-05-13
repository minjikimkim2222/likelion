package org.example.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // 이 어노테이션을 붙여야, 스프링부트 환경에서 돌아간다!!
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);

        DataService dataService = context.getBean(DataService.class);
        System.out.println(dataService.getEnvironment());
    }
}
