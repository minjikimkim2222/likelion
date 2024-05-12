package org.example.iocexample.dao;

import org.example.iocexample.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao{
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
