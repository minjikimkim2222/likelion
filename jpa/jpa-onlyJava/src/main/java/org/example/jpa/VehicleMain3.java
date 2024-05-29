package org.example.jpa;

import jakarta.persistence.EntityManager;

public class VehicleMain3 {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        Car3 car1 = new Car3();
        car1.setMenufacturer("Toyota");
        car1.setSeatCount(3);

        Truck3 truck1 = new Truck3();
        truck1.setMenufacturer("hundai");
        truck1.setPayLoadCapacity(10);

        Car3 car2 = new Car3();
        car2.setMenufacturer("Kia");
        car1.setSeatCount(7);

        em.persist(car1);
        em.persist(truck1);
        em.persist(car2);

        em.getTransaction().commit();
    }
}
