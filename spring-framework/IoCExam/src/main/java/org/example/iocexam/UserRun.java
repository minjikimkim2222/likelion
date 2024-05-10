package org.example.iocexam;

import org.example.iocexam.config.UserConfig;
import org.example.iocexam.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        System.out.println("application context 실행 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        System.out.println("application context 실행 후...");

        UserController userController = context.getBean(UserController.class);
        userController.joinUser();
    }
}
