package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "countries")
@Data
public class Country {
    @Id
    private String id;

    private String country_name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
