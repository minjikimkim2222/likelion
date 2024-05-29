package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
public abstract class Vehicle3 {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String menufacturer;
}
@Entity
@Getter @Setter
class Car3 extends Vehicle3 {
    private int seatCount; // 의자가 몇개냐

}

@Entity
@Getter @Setter
class Truck3 extends Vehicle3 {
    private double payLoadCapacity; // 짐 용량
}