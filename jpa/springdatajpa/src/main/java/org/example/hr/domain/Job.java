package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;

    private String job_title;

    private Double min_salary;

    private Double max_salary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees = new ArrayList<>();
}
