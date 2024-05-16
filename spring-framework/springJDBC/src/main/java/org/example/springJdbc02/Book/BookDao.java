package org.example.springJdbc02.Book;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


public interface BookDao {
    @Transactional
    void createAndUpdateBook(String title, String author, String newAuthor, LocalDate published_year);
    // 이미 title이 있다면, author만 update시켜준다..
}
