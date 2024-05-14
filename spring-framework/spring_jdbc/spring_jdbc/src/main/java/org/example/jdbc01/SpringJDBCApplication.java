package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);
    }

//    private JdbcTemplate jdbcTemplate;
    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){ // IoC, DI - 여기서는 Spring DATA Jdbc를 사용해 CRUD 테스트할 거니깐..
        //this.jdbcTemplate = jdbcTemplate;
        //  -- spring starter에서 이미 add dependencies로, spring data jdbc를 택했기에, jdbcTemplate 의존성 주입팔 필요는 없음..
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 실행하고픈 내용 여기에 작성..
                String sql = "INSERT INTO users (name,email) VALUES (?,?)";
                // user 입력
              //  jdbcTemplate.update(sql, "kim", "kim@exam.com");

                // user READ
                // RowMapper - select 결과값을 담을 때.. 테이블의 칼럼과 User class 필드를 직접 매치하도록 정의하자.. (강의안)
                // 테이블의 칼럼과, 클래스 필드가 완전히 일치한다면?? (user 테이블 칼럼 - User.class의 필드가 각각 일치한다..)
                    // - BeanPropertyRowMapper(User.class)에 select 결과를 담아주세요..

//                List<User> users =
//                        jdbcTemplate.query("SELECT id,name,email FROM users", new BeanPropertyRowMapper<>(User.class))
                // BeanPropertyRowMapper<>(User.class)에서 User 디폴트 생성자 사용..
//                for (User user : users) {
//                    System.out.println(user);
//                }

//                users.forEach(System.out::println);
                // select를 담을 결과값을 BeanPropertyRowMapper말고, RowMapper로 직접 만들고 싶어!!
                // RowMapper 직접 정의
                RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ); // 람다표기법 복기.. -> rowMapper에서 select하면 칼럼명을 직접 지정하면 되서, DB 칼럼명이랑 User객체 칼럼명 달라도 됨..
                // rowNum은 0부터 시작해, 각 행마다 1씩 증가..
                List<User> users = jdbcTemplate.query("SELECT id, name, email FROM users", rowMapper);
                    // jdbcTemplate.query() SQL 쿼리 실행 후 그 결과를 rowMapper에서 정의된 new User에 매핑됨..
                    // 그리고, rowMapper에 매핑된 User를 리스트로 받아왔다..
                //users.forEach(System.out::println);
                users.forEach(user -> {
                    System.out.println(user.getName() + "- " + user.getEmail());
                });

            }
        };
        /*
            혹은 람다표기법..
            return args -> {

             };
         */
    }
}
