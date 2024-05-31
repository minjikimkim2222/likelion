package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    private String department_name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
