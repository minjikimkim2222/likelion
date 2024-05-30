package org.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmailEndingWith(String condition);

    // 주어진 id값보다 작은 엔디티를 반환
    List<User> findByIdLessThan(Long id);

    // 주어진 email에 해당하는 Userlist 엔디티 반환
    List<User> findByEmail(String email);

    // 주어진 name와 email 모두를 만족하는 유저 리스트 반환
    List<User> findByNameAndEmail(String name, String email);

    // 주어진 name과 email 하나만 만족해도 유저 리스트 반환
    List<User> findByNameOrEmail(String name, String email);

    @Modifying // 데이터베이스에 수정을 하겠다는 의미!
    @Transactional
    @Query("UPDATE User u SET u.email= :email where u.id = :id") // 쿼리문 작성
    int updateUserEmail(@Param("id") Long id, @Param("email") String email);

    // @Modifying 어노테이션 메서드는 일반적으로 void 또는 int (영향을 받은 행의 개수)를 반환해야 한다!!
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = :email")
    int deleteByEmail(String email);


}
