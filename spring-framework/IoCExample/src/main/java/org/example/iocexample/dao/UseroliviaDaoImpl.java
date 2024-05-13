package org.example.iocexample.dao;

import org.example.iocexample.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Component
@Repository("oliviaDao")
public class UseroliviaDaoImpl implements UserDao{
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
        System.out.println(user + "의 정보를 oliviaDAO를 통해 잘 저장했습니다.");
    }
}
