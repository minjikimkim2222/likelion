package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) // null은 가질 수 없게끔..
    private String name;
    @ManyToMany // 사원도 여러 개.. 프로젝트도 여러 개..
    @JoinTable( // 사원테이블 - 프로젝트 테이블끼리의 관계 테이블인 employees_projects를 만든 것.
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"), // employee 테이블 객체 기준이니깐..
            inverseJoinColumns = @JoinColumn(name = "projects_id")
    )
    private Set<Project> projects = new HashSet<>(); // 사원이 프로젝트를 여러 개 가짐..
}
