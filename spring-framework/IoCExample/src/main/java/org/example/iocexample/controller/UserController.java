package org.example.iocexample.controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.iocexample.domain.User;
import org.example.iocexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class UserController {

    private UserService userService;

//    public UserController(){
//        System.out.println("UserController() 객체 생성 !!");
//    }
    //@Autowired
    public UserController(UserService userService){
        System.out.println("UserController(userService) 객체 생성 !!");
        this.userService = userService;
    }
    @PostConstruct
    public void init(){
        // 해당 빈이 생성된 직후!! 스프링이 알아서 어노테이션 보고 호출해줌..
        System.out.println("postConstruct 실행 !!");
    }

    @PreDestroy
    public void destory(){
        // //빈이 소멸되기 직전에 알아서 호출됨
        System.out.println("preDestory 실행 !!");
    }
    public void joinUser(){
        // 실제 동작할 때는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("minjiki2");
        user.setEmail("minjiki2@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
