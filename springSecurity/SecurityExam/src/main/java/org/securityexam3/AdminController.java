package org.securityexam3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    관리자페이지
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/abc") // admin권한만 접근 가능
    public String abc(){
        return "abc";
    }

    @GetMapping("/def") // admin, superuser만 접근가능
    public String def(){
        return "def";
    }

    @GetMapping("/list") // admin, superuser만 접근가능
    public String list(){
        return "list";
    }

    @GetMapping("/add") // admin, superuser만 접근가능
    public String add(){
        return "add";
    }
}
