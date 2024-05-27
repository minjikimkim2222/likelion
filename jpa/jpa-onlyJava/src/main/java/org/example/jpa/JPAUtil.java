package org.example.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.management.relation.RelationNotification;

public class JPAUtil {
    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("UserPU");

    public static EntityManagerFactory getEntityManagerFactory(){
        return emfInstance;
    }

    // java 어플리케이션이 종료될 때, 자동으로 close() 메서드가 호출되도록 함
    static {
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
           if (emfInstance != null){
               System.out.println("-------emf close-------");
               emfInstance.close();
           }
        }));
    }
}
