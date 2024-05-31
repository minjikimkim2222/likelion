package org.example.springdatajpa3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepositoryNativeQuery extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM jpa_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value = "SELECT name, email FROM jpa_user WHERE name LIKE %:name%", nativeQuery = true)
    List<Object[]> findUserByNameNative(@Param("name") String name);
}
