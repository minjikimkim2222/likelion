package org.example.iocexample;

import org.example.iocexample.config.UserConfig;
import org.example.iocexample.config.UserConfig2;
import org.example.iocexample.controller.UserController;
import org.example.iocexample.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        // 방법 1. 자바설정파일 main
//        System.out.println("applicationContext 생성 전...");
//         ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
//        //ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig2.class);
//        System.out.println("applicationContext 생성 후...");
//
//        UserController userController = context.getBean(UserController.class);
//        userController.joinUser();

        // 방법 2. @Component, @ComponentScan main..
        System.out.println("applicationContext 생성 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig2.class);
        System.out.println("applicationContext 생성 후...");

        UserController userController = context.getBean(UserController.class);
        // 왜 userController에서는 에러가 나냐??
        //  - UserConfig전부 주석처리했으니.. 의존성 주입을 모른다.
            // 의존성 주입해주는 애들을 @Autowired해주기!!
        userController.joinUser();
    }
}
