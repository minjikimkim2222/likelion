package org.example.iocexample;

import org.example.iocexample.config.UserConfig;
import org.example.iocexample.controller.UserController;
import org.example.iocexample.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        System.out.println("applicationContext 생성 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        System.out.println("applicationContext 생성 후...");

        UserController userController = context.getBean("userController2", UserController.class);
        userController.joinUser();
    }
}
