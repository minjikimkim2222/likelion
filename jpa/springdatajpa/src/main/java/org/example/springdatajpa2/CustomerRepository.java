package org.example.springdatajpa2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // 1. 메서드 이름으로 쿼리 생성하고, 테스트 코드를 만들어보세요.
    // 이름으로 조회
    Customer findByName(String name);

    // 이메일로 조회
    Customer findByEmail(String email);

    // 이메일에 특정 문자열을 포함하고 있는 고객 조회
    List<Customer> findByEmailEndingWith(String email);
    List<Customer> findByEmailContaining(String email);

    //2. @Query 어노테이션으로 쿼리 생성..
    // 이름으로 고객 조회
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findCustomerByName(@Param("name")String name);

    // 각 고객과 고객의 주문수를 알고 싶다. 이때 주문이 없어도 Customer 조회하고 싶다
    //  --- 쿼리메서드로 만들기 까다로운 부분..
    //  --- 이때 @Query 어노테이션으로 직접, 쿼리문을 작성하자!!
    @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> findCustomerOrderCount();
}
