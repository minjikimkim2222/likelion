package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
@Getter @Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    // 프로젝트 기준으로도, 프로젝트 하나에 얽힌 여러개의 사원들이 있겠지
    // 근데, 프로젝트 여러 개 - 사원 여러명 관계
    @ManyToMany(mappedBy = "projects") // Employee의 projects 멤버변수..
    private Set<Employee> employees = new HashSet<>();
}
