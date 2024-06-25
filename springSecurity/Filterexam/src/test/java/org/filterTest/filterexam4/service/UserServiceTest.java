package org.filterTest.filterexam4.service;

import org.filterTest.filterexam4.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void registerNewUser(){
        // 회원가입할 때, ROLE_USER로 값을 줌..
        User user = new User();
        user.setName("id1");
        user.setPassword("pw1");
        user.setUsername("name1");
        user.setEmail("email1@exam.com");

        System.out.println("회원가입 전 User 정보 : " +  user);
        User user1 = userService.registerUser(user);
        System.out.println("회원가입 후 User 정보 (Role - 일반유저)로 추가되었는가 : "+ user1);
        // 회원가입 전후, ROLE 유저가 추가됨을 알 수 있따.
    }
}