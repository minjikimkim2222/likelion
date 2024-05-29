package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CarExamMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

//        Car car1 = new Car();
//        car1.setMenufacturer("Toyota");
//        car1.setSeatCount(3);
//
//        Truck truck1 = new Truck();
//        truck1.setMenufacturer("hundai");
//        truck1.setPayLoadCapacity(10);
//
//        Car car2 = new Car();
//        car2.setMenufacturer("Kia");
//        car1.setSeatCount(7);
//
//        em.persist(car1);
//        em.persist(truck1);
//        em.persist(car2);

        // createQuery에서는 from 뒤에 sql처럼 테이블명이 오지 않고, 엔디티명이 온다!
        List<Vehicle> vehicles = em.createQuery("SELECT v from Vehicle v", Vehicle.class).getResultList();

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                log.info("Car info :: {}, {}", car.getId(), car.getSeatCount());
            }
            else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                log.info("Truck info :: {}, {}", truck.getId(), truck.getPayLoadCapacity());
            }
        }
        em.getTransaction().commit();
    }
}
