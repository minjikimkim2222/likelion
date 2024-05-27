package org.example.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jpa_user") // 만들어질 테이블과 엔디티객체의 이름이 다르다면..
@Getter @Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
