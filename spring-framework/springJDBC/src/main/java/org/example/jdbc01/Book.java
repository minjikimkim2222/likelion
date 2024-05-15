package org.example.jdbc01;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor // public Book(book_id,title,author,published_year) {} 생성자와 똑같은 역할..
@Getter // 각 멤버변수에 대응하는 getter와 똑같은 역할
@Setter
@ToString
@NoArgsConstructor // 디폴트 생성자
public class Book {
    private int book_id;
    private String title;
    private String author;
    private LocalDate published_year;
}
