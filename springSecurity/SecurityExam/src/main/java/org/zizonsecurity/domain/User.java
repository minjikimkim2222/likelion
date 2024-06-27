package org.zizonsecurity.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100) // password는 암호화되서 들어가니까, 생각보다 length를 크게
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "registration_date", nullable = false, updatable = false) // 등록일은 update되면 안되니깐..
    private LocalDateTime registrationDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"), // 내 엔디티 기준 칼럼
            inverseJoinColumns = @JoinColumn(name = "role_id") // 매핑된 상대편 엔디티 기준 칼럼
    )
    private Set<Role> roles;

}
