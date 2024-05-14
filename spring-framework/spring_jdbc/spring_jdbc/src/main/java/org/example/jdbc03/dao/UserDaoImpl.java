package org.example.jdbc03.dao;

import lombok.RequiredArgsConstructor;
import org.example.jdbc03.UserNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor // final가 붙은 멤버변수에 대해서만 생성자 추가
public class UserDaoImpl implements UserDao {

    // 필드 기반, 생성자든, setter든 개발자가 요즘 쓰는 방식은... final과 lombok의 조화...
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users (name,email) VALUES (?,?)";
        try {
            jdbcTemplate.update(sql, user.getName(), user.getEmail());
        } catch (DataAccessException e){
            throw new DataAccessException("사용자를 입력하다 오류 발생 " + user.getName(), e) {};
            // DataAccessException은 오류메세지와 e를 한꺼번에 보내줄 수 있다..
        }
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
    public void updateUserEmail(String name, String email) throws UserNotFoundException{
        int updated = jdbcTemplate.update("UPDATE users SET email = ? where name = ?", email, name);

        if (updated == 0)
            throw new UserNotFoundException("[update error] : No user found with name " + name);
    }

    @Override
    public void deleteUser(String name) throws UserNotFoundException{
        int deleted = jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);

        if (deleted == 0)
            throw new UserNotFoundException("[delete error] : No user found with name " + name);
    }
}
