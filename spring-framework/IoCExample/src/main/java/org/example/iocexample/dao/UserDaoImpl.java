package org.example.iocexample.dao;

import org.example.iocexample.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserDaoImpl implements UserDao{

    public UserDaoImpl(){
        System.out.println("UserDaoImpl() 객체 생성 !!");
    }
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "의 정보가 잘 저장되었습니다.");
    }
}
