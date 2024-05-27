package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {
    // User select
    public User findUser(Long id){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            User user = entityManager.find(User.class, id);// 어떤 클래스 - 조회기준
            return user;

        } finally {
            entityManager.close();
        }
    // select문이니까, insert/update/delete도 아니니 트랜잭션 추가할 필요 없
    }
    public void createUser(User user){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(user);

            entityManager.getTransaction().commit();
        } finally {
             entityManager.close();
        }
    }
}
