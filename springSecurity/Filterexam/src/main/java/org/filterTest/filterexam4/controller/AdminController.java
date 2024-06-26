package org.filterTest.filterexam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    사용자 권한에 따라 접근가능한 페이지를 달라지게 함.
 */
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
