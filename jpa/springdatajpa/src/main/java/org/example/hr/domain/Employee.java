package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
@Getter @Setter
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone_number;

    private Date hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Double salary;

    private Double commission_pct; // 판매실적에 따른 보너스

    @ManyToOne // 직원여러명 - 매니저 1명
    @JoinColumn(name = "manager_id")
    private Employee manager; // 매니저도 직원임!!!!!!!

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private Set<JobHistory> jobHistories;



}
