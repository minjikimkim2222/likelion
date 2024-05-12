package org.example.iocexample.controller;

import org.example.iocexample.domain.User;
import org.example.iocexample.service.UserService;

public class UserController {
    private UserService userService;

    public void joinUser(){
        // 실제 동작할 때는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("minjiki2");
        user.setEmail("minjiki2@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
