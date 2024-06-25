package org.filterTest.filterexam;

import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
public class HomeController {

    public HomeController(){
      log.info("### home controller 생성자 호출 ###");
    }
    @GetMapping("/")
    public String home(){
        log.info("home() 실행");
        return "home";
    }

    @GetMapping("/hi")
    public String hi(){
        log.info("hi() 실행");
        return "hi";
    }
}
