//package org.filterTest.filterexam3;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@Slf4j
//public class UserController {
//
//    @GetMapping("/loginform")
//    public String loginform(Model model){
//        model.addAttribute("user", new User());
//        return "loginform";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user, HttpServletResponse response){
//        log.info("username : {}", user.getUsername());
//        log.info("password : {}", user.getPassword());
//
//        // 우선 회원가입 기능구현 대신, minjiki2 / 1234 유저가 있다고 가정한다.
//        if (user.getUsername().equals("minjiki2") && user.getPassword().equals("1234")){
//            // 로그인이 된 거면, 쿠키에 사용자정보를 담아둔다 !!
//            Cookie cookie = new Cookie("auth", "minjiki2");
//            cookie.setPath("/");
//
//            // 이렇게 생성된 쿠키는 클라이언트에게 보내주어야 함.
//            response.addCookie(cookie);
//
//            // 이후부터, 클라이언트의 쿠키에 "auth"라는 쿠키name을 가지고 있다면, 로그인한 사용자가 맞구나 !! 라고 파악 가능 !
//            return "welcome";
//        }
//        return "redirect:/loginform";
//    }
//
//    @GetMapping("/welcome")
//    public String welcome(){
//        return "welcome";
//    }
//
//    @GetMapping("/info")
//    public String info(HttpServletRequest request){
//        // 아무나 볼수있는 페이지는 아니고,
//        // 로그인한 사용자에게만 보여줍니다.
//
//        // '사용자'가 가진 쿠키의 사용자정보 와 서버의 DB의 사용자정보가 같은지 아닌지 확인
//
//        // Filter 추가해서, info에 인가 정보 처리해줘도 됨 !
//        User user = UserContext.getUser();
//        String auth = user.getUsername();
//
//        if (auth != null)
//            return "info";
//        else
//            return "redirect:/loginform";
//    }
//}
