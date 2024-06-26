package org.filterTest.filterexam4.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.filterTest.filterexam4.dto.UserLoginDTO;
import org.filterTest.filterexam4.entity.User;
import org.filterTest.filterexam4.filter.UserContext;
import org.filterTest.filterexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인 폼 요청
    @GetMapping("/loginform")
    public String loginform(Model model){
        model.addAttribute("user", new UserLoginDTO());
        return "loginform";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserLoginDTO userLoginDTO, HttpServletResponse response){
        User byUser = userService.findByUsername(userLoginDTO.getUsername());

        log.info(">>>>> byUser : {} <<<<", byUser);
        // 인가를 위해, 사용자정보("auth",username)을 쿠키에 추가해준다.
        if (byUser != null && userLoginDTO.getPassword().equals(byUser.getPassword())){
            Cookie cookie = new Cookie("auth", userLoginDTO.getUsername());
            cookie.setPath("/");

            // 이렇게 생성된 쿠키는, 클라이언트에게 보내져야 한다 !!
            response.addCookie(cookie);

            return "welcome";
        }
        return "redirect:/loginform";
    }

    // welcome
    // 인가 test
    // 필터에서 UserContext에다가 모든 요청 때마다, 쿠키값이 있고 + login에서 설정한 쿠키id("auth")와 같다면, User 엔디티를 저장하라고 했음.
    // 로그인한 사용자만 welcome.html 뷰로, 로그인안한 사용자는 loginform으로
    @GetMapping("/welcome")
    public String welcomePage(){
        User user = UserContext.getUser();

        log.info(">>>> username : {}", user.getUsername());
        if (user.getUsername() != null && user.getUsername().equals("auth"))
            return "welcome"; // 로그인한 사용자
        else
            return "redirect:/loginform";
    }

    // info -- 로그인에서, 추가한 사용자정보쿠키를, 인가를 위해 사용한다.
    // -- 로그인한 사용자만 info.html 뷰로, 로그인하지 않았다면 redirect:/loginform

    @GetMapping("/info")
    public String info(){
//        User user = UserContext.getUser();
//        String auth = user.getUsername();
//
//        if (user != null && user.getUsername() != null) {
            return "info";
//        }
//
//        return "redirect:/loginform";
    }
}
