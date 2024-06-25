package org.filterTest.filterexam2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    @GetMapping("/")
    public String home(){
        log.info("home() 실행");
        return "home";
    }

    @GetMapping("/hi")
    public String hi(){
        User user = UserContext.getUser();
        log.info("hi(), user : {}", user);
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(){
        userService.list();
        log.info("hello() 실행");
        return "hello";
    }
}
