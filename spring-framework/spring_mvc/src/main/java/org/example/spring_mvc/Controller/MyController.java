package org.example.spring_mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
    @GetMapping("/home")
    public String name(){
        return "home"; // @Controller는 뷰를 리턴하기 때문에, 문자열 "home"을 리턴하는 것이 아니라, 뷰 이름 "home"을 리턴..
    }

    @GetMapping("/aboutMe")
    public String aboutMe(){
        return "aboutMe";
    }

    @GetMapping("/bread")
    public String breadLover(){
        return "bread";
    }

}
