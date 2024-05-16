package org.example.springJdbc02.User;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createAndUpdateUser(String name, String email, String newEmail) {
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?,?)", name, email);

        // 일부터 insert와 update 중간에 에러 발생시킴..
        if (newEmail.contains("error")){
            throw new RuntimeException("Simulated Error...");
        }

        jdbcTemplate.update("UPDATE users SET email = ? where name = ?", newEmail, name);
    }
}
