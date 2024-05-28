package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne // Student 기준, school과 다대일 관계
    @JoinColumn(name = "school_id") // student 테이블의 어떤 필드를 이용해 매핑할지는 알려줘야겠지
    private School school;

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }
}
