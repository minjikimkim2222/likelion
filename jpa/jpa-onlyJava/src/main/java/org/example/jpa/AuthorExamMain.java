package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorExamMain {
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            Book book = em.find(Book.class, 1L);
            log.info("book title : {}", book.getTitle());

            Author author = em.find(Author.class, 2L);
            log.info("author name : {}", author.getName());

            for (Book book2 : author.getBooks()){
                log.info("book title : {}", book2.getTitle());
            }
        } finally {
            em.close();
        }
    }

    public static void insert(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Book book = new Book("해리포터");
            em.persist(book);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Book book = em.find(Book.class, 5L);
            book.setTitle("updated 해리포터");
            em.merge(book);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Book book = em.find(Book.class, 5L);
            em.remove(book);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        //find();
        //insert();
       // update();
        delete();
    }
}
