package org.example.springJdbc06;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public class UserDao {
    @Autowired // 이번엔 의존성 주입을 필드주입기반으로..
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired // 내가 SqlConfig에서 등록한 빈 객체..
    private Properties sqlQueries; // 주의!! SqlConfig 설정파일에서 설정한 빈id 그대로 해줘야 제대로 의존성 주입!!

    public void insertUser(User user){
        String sql = sqlQueries.getProperty("INSERT_USER");

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", user.getName()); // 이때 paramName은 queries.sql의 INSERT_USER의 :변수와 동일해야 할 것!!
        params.addValue("email", user.getEmail());

        namedParameterJdbcTemplate.update(sql, params);
    }
}
