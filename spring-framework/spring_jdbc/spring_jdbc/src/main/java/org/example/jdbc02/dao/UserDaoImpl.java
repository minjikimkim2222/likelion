package org.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor // final가 붙은 멤버변수에 대해서만 생성자 추가
public class UserDaoImpl implements UserDao{

    // JdbcTemplate 객체를 이용해서 구현할거니까... 얻어오기
//    // 필드 기반
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // 생성자 기반
//    public UserDaoImpl(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//      // setter 기반
//      public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//          this.jdbcTemplate = jdbcTemplate;
//      }
    // 필드 기반, 생성자든, setter든 개발자가 요즘 쓰는 방식은... final과 lombok의 조화...
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users (name,email) VALUES (?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users =
                jdbcTemplate.query("SELECT id,name,email FROM users", new BeanPropertyRowMapper<>(User.class));

        // BeanPropertyRowMapper 객체를 사용해, 결과 집합을 객체로 매핑할 때,
            // User클래스의 디폴트 생성자와 setter 들이 있어야, 해당 객체의 필드에 값을 지정해주며 만들어질 수 있따!!
        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
        jdbcTemplate.update("UPDATE users SET email = ? where name = ?", email, name);
    }

    @Override
    public void deleteUser(String name) {
        jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);
    }
}
