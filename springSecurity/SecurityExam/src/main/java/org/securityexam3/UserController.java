package org.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @GetMapping("/mypage")
    @ResponseBody
    public String mypage(@AuthenticationPrincipal UserDetails userDetails){
        log.info("username : {}", userDetails.getUsername());
        log.info("password : {}", userDetails.getPassword());

        return "USER role의 사용자만 접근 가능 !!";
    }

    @GetMapping("/mypage2")
    public String mypage2(){
        return "mypage";
    }
}
