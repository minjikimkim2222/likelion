package org.example.iocexample;

import org.example.iocexample.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IoCExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IoCExampleApplication.class, args);

        UserController userController = context.getBean(UserController.class);
        userController.joinUser();
    }

}
