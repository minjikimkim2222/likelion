package org.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserDaoRun {

    //private static final Logger logger = LoggerFactory.getLogger("UserDaoRun");
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // findUser test
//        log.info("===================findUser()==============");
//        User findUser = userDao.findUser(1L);
//        User findUser2 = userDao.findUser(1L);
//
//        if (findUser == findUser2)
//            log.info("findUser == findUser2");
//        else
//            log.info("findUser != findUser2");

        // update test
//        User user = new User();
//        user.setId(2L);
//        user.setName("updateTest");
//        user.setEmail("update@email.com");
//
//        userDao.updateUser(user);

        //delete test
        User user = new User();
        user.setId(2L);

        userDao.deleteUser(user);

    }
}
