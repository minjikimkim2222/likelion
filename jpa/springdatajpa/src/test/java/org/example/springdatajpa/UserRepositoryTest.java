package org.example.springdatajpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void save(){
        User user = new User("test", "test@example.com");
        userRepository.save(user);

        //System.out.println(user.getId());
        Assertions.assertEquals("test", user.getName());
    }

    @Test
    void findByName(){
        List<User> users = userRepository.findByName("minjiki2");

        Assertions.assertEquals(2, users.size());
        for (User user : users){
            Assertions.assertEquals("minjiki2", user.getName());
        }
    }

    @Test
    void findByEmailEndingWith(){
        List<User> emailEndingWith = userRepository.findByEmailEndingWith("@example.com");

        Assertions.assertEquals(2, emailEndingWith.size()); // 해당 @example.com으로 끝나는 이메일 유저는 2명

        for (User user : emailEndingWith){
            Assertions.assertEquals("minjiki2@example.com", user.getEmail());
        }
    }

    @Test
    void findByIdLessThan(){
        List<User> lessThanUsers = userRepository.findByIdLessThan(2L);

        Assertions.assertEquals(1, lessThanUsers.size());

        for (User user : lessThanUsers){
            Assertions.assertEquals(1L, user.getId());
        }

    }

    @Test
    void findByEmail(){
        List<User> usersbyEmail = userRepository.findByEmail("minjiki2@example.com");

        Assertions.assertEquals(2, usersbyEmail.size());
    }

    @Test
    void findByNameAndEmail(){
        List<User> users = userRepository.findByNameAndEmail("minjiki2", "test@exam.com");

        Assertions.assertEquals(1, users.size());
        System.out.println(users.getFirst());
    }

    @Test
    void findByNameOrEmail(){
        List<User> users = userRepository.findByNameOrEmail("minjiki2", "test@exam.com");

        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    void updateUserEmail(){
        userRepository.updateUserEmail(3L, "new@exam.com");

        User user = userRepository.findById(3L).orElse(null);

        Assertions.assertEquals("new@exam.com", user.getEmail());
    }

    @Test
    void deleteByEmail(){
        int rowsAffected = userRepository.deleteByEmail("new@exam.com");

        Assertions.assertEquals(1, rowsAffected);
    }
}