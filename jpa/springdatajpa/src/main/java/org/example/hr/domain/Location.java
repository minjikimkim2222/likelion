package org.example.hr.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class Location {
    @Id
    private Long location_id;
    private String street_address;

    private String postal_code;

    private String city;

    private String state_province;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
