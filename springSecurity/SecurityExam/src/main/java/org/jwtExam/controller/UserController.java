package org.jwtExam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jwtExam.service.UserService;
import org.jwtExam.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @GetMapping("/userregform")
    public String userregform(Model model){
        model.addAttribute("user", new User());
        return "users/userregform";
    }

    @PostMapping("/userreg")
    public String userreg(@ModelAttribute("user") User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "userregform";
        }
        log.info("user : {}", user);

        User byUsername = userService.findByUsername(user.getUsername());

        if (byUsername != null){
            // 회원가입한 유저가 이미 존재함..
            bindingResult.rejectValue("username", null, "이미 사용중인 아이디입니다.");
        }
        userService.registerUser(user);

        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "users/welcome";
    }

    // 로그인 관련 컨트롤러 추가

    @GetMapping("/loginform")
    public String loginform(){
        return "users/loginform";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
