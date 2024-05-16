package org.example.springJdbc02.User;

import org.springframework.transaction.annotation.Transactional;

public interface UserDao {
    @Transactional
    void createAndUpdateUser(String name, String email, String newEmail);
}
