package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter @Setter
@NoArgsConstructor
public class PassPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String passportNumber;

    @Column(unique = true) // UNIQUE
    private Long personId;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true) // 1대 1이라 unique 설정!
    private Person person;

    public PassPort(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
