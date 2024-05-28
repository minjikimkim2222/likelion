package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        // persistence.xml에서 persistence-unit이름으로 지정한 "userPU"
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = enf.createEntityManager();

        // 엔디티 생성된 상황 -- 현재 이 엔디티는, 아직은 영속성 컨텍스트에서 관리하지 않는 상태..
//        User user = new User();
//        //user.setId(1L);
//        user.setName("kim");
//        user.setEmail("kim@email.com");
//
//        // 여기까지도 영속성 컨텍스트가 관리하지는 않음.
//        entityManager.getTransaction().begin(); // 트랜잭션 안에서 동작시켜야 함..
//
//        // 영속성 컨텍스트에게 관리를 맡김
//        entityManager.persist(user);
//
//        // 이때 DB에 저장함 (commit을 해야 비로소..)
//        entityManager.getTransaction().commit();

        //
//        User user1 = entityManager.find(User.class, 1L);
//        User user2 = entityManager.find(User.class, 1L);
//
//        if (user1 == user2)
//            System.out.println("user1 == user2");
//        else
//            System.out.println("user1 != user2");

        // update
//        User user1 = entityManager.find(User.class, 1L);
//
//        entityManager.getTransaction().begin();
//
//        user1.setEmail("new_kim@email.com");
//        user1.setName("updateUser");
//
//        user1.setEmail("new_kim@email.com");
//        user1.setName("updateUser");
//        // 커밋해야, 변경사항이 DB에 반영된다!!!
//        entityManager.getTransaction().commit();

        // delete
        User user1 = entityManager.find(User.class, 1L);

        entityManager.getTransaction().begin();

        entityManager.remove(user1);

        entityManager.getTransaction().commit();
    }
}
