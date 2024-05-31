package org.example.springdatajpa4;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> findUsersDynamically(String name, String email);

    List<User> findUsersByName(String name);
}
