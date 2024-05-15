package org.example.jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor // final이 붙은 멤버변수에 대해서만 생성자 추가 - 의존성 주입..
@Repository // 빈으로 등록해야, SpringJDBC02Application이 실행된 후, 인식할 테니..
public class BookDaoImpl implements BookDao{
    private final JdbcTemplate jdbcTemplate; // @RequiredArgsConstructor를 통해 의존성 주입.,.
    @Override
    public void insertBook(Book book) {
        String sql = "insert into books (title, author, published_year) values (?,?,?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPublished_year());
    }

    @Override
    public List<Book> findAllBooks() {
        RowMapper<Book> rowMapper = (ResultSet rs, int rowNum) ->
          new Book(
                  rs.getInt("book_id"),
                  rs.getString("title"),
                  rs.getString("author"),
                  rs.getDate("published_year").toLocalDate()
          );
        List<Book> books = jdbcTemplate.query("select * from Books", rowMapper);
        return books;
    }

    @Override
    public void updateBookAuthor(int book_id, String title) {

        jdbcTemplate.update("update books set title = ? where book_id = ?", title, book_id);
    }

    @Override
    public void deleteBook(int book_id) {
        jdbcTemplate.update("delete from Books where book_id = ?", book_id);
    }
}
