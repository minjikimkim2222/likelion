package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            // select는 트랜잭션 안 해줘도 됨..
            Person person = em.find(Person.class, 1L);
            log.info("person name : {}", person.getName());

            // person 1의 passport는?
            log.info("person 1의 passport : {}", person.getPassPort().getPassportNumber());

        } finally {
            em.close();
        }
    }

    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Person person = em.find(Person.class, 3L);
            em.remove(person);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Person person = new Person();
            person.setName("5번 person");

            PassPort passPort = new PassPort();
            passPort.setPassportNumber("5번 passport number");

            /// 연관관계 설정!!
            person.setPassPort(passPort);
            // passPort.setPerson(person); -- 일대일 대응관계라 생략 가능!
            em.persist(person);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Person person = em.find(Person.class, 5L);

            person.setName("update 5번..");

            em.persist(person);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        //find();
        //delete();
        // create();
        update();
    }
}
