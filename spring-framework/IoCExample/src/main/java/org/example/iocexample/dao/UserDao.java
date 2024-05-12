package org.example.iocexample.dao;

import org.example.iocexample.domain.User;

import java.util.List;

public interface UserDao {
    // UserDao는 User에 의존한다..
    public User getUser(String email);
    public List<User> getUsers();

    public void addUser(User user);
}
