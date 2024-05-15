package org.example.springDataJdbc01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

// 엔디티 클래스 (DTO는 단순히 값만 담아서 전달하는 객체라면..) 엔디티는 데이터베이스와의 관계를 알려주는 역할도 해줌..
@Table("books") // 테이블명이랑 클래스명이 같으면 이름을 따로 선언할 필요는 없지만, 다르기 때문에 선언해줌..
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    private int book_id;
    private String title;
    private String author;
    private LocalDate published_year;

    public Book(String title, String author, LocalDate published_year){
        this.title = title;
        this.author = author;
        this.published_year = published_year;
    }
}
