package org.example.springJdbc02;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@RequiredArgsConstructor // final 변수 생성자 생성해서, 의존성 주입..
@Repository
public class BookDaoImpl implements BookDao{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void createAndUpdateBook(String title, String author, String newAuthor, LocalDate published_year) {
        String sql = "insert into books(title,author,published_year) values (?,?,?)";
        jdbcTemplate.update(sql, title,author,published_year);
        // 이미 있는 book author이라면 오류를 발생시켰을 것..

        // 실제 에러는 아니고, introduce an error to test transaction rollback... (일부로 예외를 발생시킨 것..)
        if (newAuthor.contains("error")){
            throw new RuntimeException("Simulated error...");
        }
        jdbcTemplate.update("update books set author = ? where title = ?", newAuthor, title);
    }
}
