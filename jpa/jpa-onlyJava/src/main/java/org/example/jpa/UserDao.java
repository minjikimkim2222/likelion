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

    public void updateUser(User user){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(user); // 매개변수 user를 영속성 컨텍스트에 가져가준다.

            em.getTransaction().commit();
            // 영속성 컨텍스트에 새롭게 들어온 user id값이, 이미 DB에 존재함.
            // 근데, 두 대상이 서로 다르다면, 커밋할 때 영속성 컨텍스트의 변경사항이 DB로 update !!
        } finally {
            em.close();
        }
    }

    public void deleteUser(User user){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();

            em.remove(em.contains(user) ? user : em.merge(user));
            // user가 없다면, 우선 merge시켜서 영속성 컨텍스트에 연결 -> 그래야 DB와 연결됨
            // user가 있다면, remove

            em.getTransaction().commit();

        } finally {
            em.close();
        }
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
