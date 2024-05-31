package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regions")
@Data
public class Region {
    @Id
    private Integer id;

    private String region_name;

}
