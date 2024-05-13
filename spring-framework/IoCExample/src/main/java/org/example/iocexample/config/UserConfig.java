package org.example.iocexample.config;

import org.example.iocexample.controller.UserController;
import org.example.iocexample.dao.UserDao;
import org.example.iocexample.dao.UserDaoImpl;
import org.example.iocexample.domain.User;
import org.example.iocexample.service.UserService;
import org.example.iocexample.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    //IOC 컨테이너에 Bean을 등록하는 방법을 생각해보고 동작 될 수 있도록 작성해주세요.
    //1. javaconfig를 이용해서 동작되도록!!

//    @Bean
//    public User user(){
//        return new User();
//    }
//
//    @Bean
//    public UserDao userDao(){
//        return new UserDaoImpl();
//    }
//
////    @Bean
////    public UserServiceImpl userServiceImpl(){
////        return new UserServiceImpl();
////    }
//
//    @Bean
//    public UserService userService2(UserDao userDao){
//        return new UserServiceImpl(userDao);
//    }
//
////    @Bean
////    public UserController userController(){
////        return new UserController();
////    }
//
//    @Bean
//    public UserController userController2(UserService userService){ // UserService 빈이 여러개가 있어서, 1개 주석처리함..
//        return new UserController(userService);
//    }

    //2. componentScan 을 이용해서 동작되도록...     코드를 완성해보세요.
        // -> UserConfig2.java
}
