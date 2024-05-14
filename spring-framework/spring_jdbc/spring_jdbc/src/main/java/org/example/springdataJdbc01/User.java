package org.example.springdataJdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// 엔디티 클래스 (DTO는 단순히 값만 담아서 전달되는 객체라면..) 엔디티는 데이터베이스와의 관계를 알려주는 역할도 해줌..
@Table("users") // 테이블명이랑 클래스명이 같으면 이름을 따로 선언할 필요없지만, 다르기 때문에 선언해줌..
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private Long id; // table id 설정
    private String name;
    private String email;

    // name과 email만 받는 생성자
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
