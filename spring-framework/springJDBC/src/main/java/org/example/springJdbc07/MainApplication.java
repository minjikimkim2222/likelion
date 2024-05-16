package org.example.springJdbc07;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){ // 이미 스프링 starter에서 JdbcTemplate이름으로 빈을 등록했기 때문..
        return args -> {
            // text blocks을 이용한 멀티 라인 SQL 쿼리
            String sql =   """
                            INSERT INTO users (name,email)
                            VALUES (?,?);
                           """;
            jdbcTemplate.update(sql, "insertTEST22", "insertTEST22@email.com");

            // 멀티 라인 쿼리로 여러 개의 데이터 조회
            String query =  """
                             SELECT id,name,email
                             FROM users;
                            """;
            jdbcTemplate.query(query, rs -> {
                while (rs.next()){
                    System.out.println("User: " + rs.getString("name") + " - " + rs.getString("email"));
                }
            });
        };
    }
}
