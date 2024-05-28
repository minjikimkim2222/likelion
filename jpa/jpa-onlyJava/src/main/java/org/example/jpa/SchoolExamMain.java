package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            // 1번 school 이름과, 해당 학교에 다니는 학생들 select
            School school = em.find(School.class, 1L);
            log.info("School name : {}", school.getName());

            for (Student student : school.getStudents()){
                log.info("Student name : {}", student.getName());
            }

            // 2번 student SELECT
            Student student = em.find(Student.class, 2L);
            log.info("student name : {}", student.getName());
        } finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = new School("선곡초");

            Student student1 = new Student("김민지", school);
            Student student2 = new Student("최성경", school);
            Student student3 = new Student("박민영", school);

            school.getStudents().add(student1);
            school.getStudents().add(student2);
            school.getStudents().add(student3);

            // 해당 엔디티를 영속화시켜야, 커밋 시 변경전후사항을 비교해 데이터베이스 접근 가능
            em.persist(school);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = em.find(School.class, 3L); // 선곡초
            school.setName("updated school Name");

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = em.find(School.class, 4L);
            em.remove(school); // 이때 School 객체에 cascade, 고아객체도 같이 삭제해달라고 했으니, 연관된 students 도 같이 삭제될 것!

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public static void main(String[] args) {
       // find();
      // create();
       // update();
        delete();
    }
}
