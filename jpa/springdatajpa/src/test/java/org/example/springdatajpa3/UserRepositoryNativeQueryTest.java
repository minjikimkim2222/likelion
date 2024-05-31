package org.example.springdatajpa3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@SpringBootTest
@Transactional
class UserRepositoryNativeQueryTest {

    @Autowired
    private UserRepositoryNativeQuery nativeQuery;

    @Test
    void findByEmailNative(){
        List<User> users = nativeQuery.findByEmailNative("g@example.com");

        assertThat(users).hasSize(2);
    }

}