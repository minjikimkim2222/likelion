package org.example.springJdbc05;

import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        // 실제 실행코드는 CommandLineRunner...
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){
        return args -> {
            String sql = "SELECT id,name,email FROM users";
            User user = jdbcTemplate.query(sql, new UserResultSetExtractor());
            System.out.println(user);
        }; // CommandLineRunner - 람다식 (함수형 인터페이스..)
    }

    private static class UserResultSetExtractor implements ResultSetExtractor<User> {
        // ResultSetExtractor 결과 집합 전체를, 단일 객체로 변환하는데 사용..
        // 여러 테이블에서 조인된 결과를 받아서, 하나의 복합 객체로 매핑..
        // (RowMapper함수와 달리), 메서드가 '한번만' 호출되서, 전체 결과 집합을 처리..
        @Override
        public User extractData(ResultSet rs) throws SQLException, DataAccessException {
            User user = new User();
            if (rs.next()){ // for문 아니고 if문.. user 1개에 대한 처리만..
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

                // 지금 예제는 user 1개에 대한 값만 채우는거라.. RowMapper와 크게 차이는 없어보이지만,
                // 만일 게시글이라면... 게시글 하나에 댓글 리스트가 필드로 들어와 있을 수 있음..(PK - FK)
            }
            return user;
        }
    }
}

