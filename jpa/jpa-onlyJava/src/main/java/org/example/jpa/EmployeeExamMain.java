package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeExamMain {
    public static void main(String[] args) {
        //find();
        //create();
        update();
        //delete();

    }

    public static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        // select는 트랜잭션해줄 필요없음.. 데이터베이스에 아무런 변화(insert, delete, update)를 끼치지 못하잖아..

        try {
            Employee employee = em.find(Employee.class, 1L);
            log.info("employee name : {}", employee.getName());

            log.info("1번 employee에 대한 프로젝트 title ...");
            for (Project project : employee.getProjects()){
                log.info("project : {}", project.getTitle());
            }
        } finally {
            em.close();
        }
    }

    public static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Employee employee = new Employee();
            employee.setName("김민지");

            Project project = new Project();
            project.setTitle("스프링 프로젝트");

            // 다대다 관계 생성..
            employee.getProjects().add(project);
            project.getEmployees().add(employee);

            // 각 엔디티들을 영속화!
            em.persist(employee);
            em.persist(project);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
//            Employee findEmployee = em.find(Employee.class, 3L);
//            findEmployee.setName("김민지 -> update");

            // 1번 사원이 2번 프로젝트에서 빠지고 싶다..
            Employee employee = em.find(Employee.class, 1L);
            employee.getProjects().remove(em.find(Project.class, 2L));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Employee employee = em.find(Employee.class, 3L);
            em.remove(employee);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
