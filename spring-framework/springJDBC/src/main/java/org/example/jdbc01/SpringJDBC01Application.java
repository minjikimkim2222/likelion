package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class SpringJDBC01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC01Application.class, args);
        // 스프링부트 실행은 시킨 뒤..
        // 실제 실행코드는 CommandLineRunner에서..
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){ // CommandLineRunner에서 JdbcTemplate 객체를 사용할 거니, 의존성 주입..
        // @Bean어노테이션이 적용된 메서드의 매개변수로, 다른 객체 의존성 주입 가능..
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                //// 1. INSERT
                //String insertSQL = "insert into books (book_id, title,author) values (?, ?, ?)";
                //jdbcTemplate.update(insertSQL,7,"test2", "kim");

                //// 2.  READ - 람다식으로 select 결과값을 담을 rowMapper 만듦..
                    // 2-1. rowMapper - ResultSet에서 가져온 각 행(row)을, 객체에 매핑할 공간!!
                RowMapper<Book> rowMapper = (ResultSet rs, int rowNum) ->
                    new Book(
                            rs.getInt("book_id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDate("published_year").toLocalDate()
                    );
                List<Book> books =
                        jdbcTemplate.query("select book_id, title, author,published_year from books",rowMapper);
                    // select를 실행하면, RowMapper는 각 ResultSet의 행(row)를 정의한 rowMapper대로, Book 객체에 매핑..
                    // 모든 행들을 전부 객체로 매핑시켰다면, 여러 개의 Book 객체를 리스트로 리턴해줌..
                books.forEach(book -> System.out.println(book));

                    // 2-2. 만일, 테이블 칼럼과 클래스의 필드가 완전히 일치하다면.. - BeanPropertyRowMapper(Book.class)로 select 결과 담을 수 있다..
                    // RowMapper는 직접 getInt로 필드명 가져올 수 있으니, 언제든 사용가능..
                List<Book> books2 =
                        jdbcTemplate.query("select book_id, title, author,published_year from books", new BeanPropertyRowMapper<>(Book.class));
                books2.forEach(book -> System.out.println(book));

                //// 3. update
                jdbcTemplate.update("update books set author = ? where title = ?", "update Author", "1984");

                //// 4. delete
                jdbcTemplate.update("delete from books where author = ?", "update Author");


            }
        };
    }
}
