package org.filterTest.filterexam4.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 굳이 우리가 Role을 통해서, User의 모든 정보들을 알 필요가 있을까요?
//    @ManyToMany
//    List<User> users;
}
