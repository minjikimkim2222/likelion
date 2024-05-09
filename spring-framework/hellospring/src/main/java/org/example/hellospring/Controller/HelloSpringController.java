package org.example.hellospring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @RequestMapping("/hello")
    public String hello(){
        return "<h1>hello</hi>";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
