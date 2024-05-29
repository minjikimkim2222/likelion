package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속관계에 있는 클래스들을 1개의 테이블로
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING) // 구분할 '필드명'은 type, type필드의 자료형은 String
@Getter @Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menufacturer;
}

@Entity
@DiscriminatorValue("CAR")
@Getter @Setter
class Car extends Vehicle {
    private int seatCount; // 의자가 몇개냐

}

@Entity
@DiscriminatorValue("TRUCK")
@Getter @Setter
class Truck extends Vehicle {
    private double payLoadCapacity; // 짐 용량
}