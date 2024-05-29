package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleMain2 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
//        em.getTransaction().begin();
//
//        Car2 car1 = new Car2();
//        car1.setMenufacturer("Toyota");
//        car1.setSeatCount(3);
//
//        Truck2 truck1 = new Truck2();
//        truck1.setMenufacturer("hundai");
//        truck1.setPayLoadCapacity(10);
//
//        Car2 car2 = new Car2();
//        car2.setMenufacturer("Kia");
//        car1.setSeatCount(7);
//
//        em.persist(car1);
//        em.persist(truck1);
//        em.persist(car2);
//
//        em.getTransaction().commit();

        // createQuery에서는 from 뒤에 sql처럼 테이블명이 오지 않고, 엔디티명이 온다!
        List<Vehicle2> vehicles = em.createQuery("SELECT v from Vehicle2 v", Vehicle2.class).getResultList();

        for (Vehicle2 vehicle : vehicles) {
            if (vehicle instanceof Car2) {
                Car2 car = (Car2) vehicle;
                log.info("Car info :: {}, {}", car.getId(), car.getSeatCount());
            }
            else if (vehicle instanceof Truck2) {
                Truck2 truck = (Truck2) vehicle;
                log.info("Truck info :: {}, {}", truck.getId(), truck.getPayLoadCapacity());
            }
        }
    }
}
