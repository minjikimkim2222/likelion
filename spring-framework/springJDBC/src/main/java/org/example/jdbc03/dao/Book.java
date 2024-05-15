package org.example.jdbc03.dao;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id; // RowMapper 사용할 거니, book_id 아니어도 괜찮..
    private String title;
    private String author;
    private LocalDate published_year;

    public Book(String title, String author, LocalDate published_year){
        this.title = title;
        this.author = author;
        this.published_year = published_year;
    }
}
