package org.filterTest.filterexam4.repository;

import org.filterTest.filterexam4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // id는 의미없는 값이므로, 우리는 username을 찾아오는 메서드 필요
    User findByUsername(String username);

}
