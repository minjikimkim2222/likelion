package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "schools")
@Getter @Setter
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();
    // 학교 기준, 학생과 일대다
    // mappedBy - 해당 schools 테이블에는 매핑될 필드가 없음.
    //      대신, Student.java에서 생성한 School school 멤버변수와 매핑된다는 정보는 줘야함.
    // cascade - CascadeType.ALL - 수정/삭제 시 연관된 엔디티까지 다 수정/삭제
    // orphanRemoval = true - 고아객체까지 같이 지우겠다.


    public School(String name) {
        this.name = name;
    }
}
