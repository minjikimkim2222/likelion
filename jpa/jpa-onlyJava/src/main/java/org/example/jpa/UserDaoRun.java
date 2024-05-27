package org.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class UserDaoRun {

    //private static final Logger logger = LoggerFactory.getLogger("UserDaoRun");
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

//        User minjiki2User = new User("minjiki", "minjikiDao@dao.com");
//        userDao.createUser(minjiki2User);

        // 로그 레벨 설정
        // @Slf4j를 이용할 때는 log 변수를 사용한다.
//        log.info("Created user : {}" , minjiki2User.getName());
//        log.info("user email : {}", minjiki2User.getEmail());
//        log.info("user id : {}", minjiki2User.getId());

        // findUser test
        log.info("===================findUser()==============");
        User findUser = userDao.findUser(1L);
        log.info("Found user : {}", findUser.getName());

    }
}
