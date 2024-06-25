package org.filterTest.filterexam2;

import org.springframework.stereotype.Service;

import java.io.PrintStream;

//@Service
public class UserService {
    public void list(){
        User user = UserContext.getUser();

        // user 유무에 따라서 비즈니스가 다르게 처리될 수 있을 것.
        System.out.println(user);
    }
}
