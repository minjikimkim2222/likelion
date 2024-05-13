package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){ // IoC, DI - 여기서는 Spring DATA Jdbc를 사용해 CRUD 테스트할 거니깐..
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 실행하고픈 내용 여기에 작성..
                String sql = "INSERT INTO users (name,email) VALUES (?,?)";
                // user 입력
                jdbcTemplate.update(sql, "kim", "kim@exam.com");

                // user READ
                // RowMapper - select 결과값을 담을 때.. 테이블의 칼럼과 User class 필드를 직접 매치하도록 정의하자.. (강의안)
                // 테이블의 칼럼과, 클래스 필드가 완전히 일치한다면?? (user 테이블 칼럼 - User.class의 필드가 각각 일치한다..)
                    // - BeanPropertyRowMapper(User.class)에 select 결과를 담아주세요..

                List<User> users = jdbcTemplate.query("SELECT id,name,email FROM users", new BeanPropertyRowMapper<>(User.class));

//                for (User user : users) {
//                    System.out.println(user);
//                }

                users.forEach(System.out::println);

            }
        };
        /*
            혹은 람다표기법..
            return args -> {

             };
         */
    }
}
