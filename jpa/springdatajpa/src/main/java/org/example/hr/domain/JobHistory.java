package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "job_history")
@Data
public class JobHistory {
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    private Date start_date;

    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
