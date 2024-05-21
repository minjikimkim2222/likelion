package org.example.spring_mvc.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
    @GetMapping("/visit")
    public String showVisit(
        @CookieValue(name = "lastVisit", defaultValue = "N/A") String lastVisit,
        @CookieValue(name = "user1", defaultValue = "default") String user1,
        HttpServletResponse response, Model model, HttpServletRequest request
        )
    {
        // 쿠키값은 RFC-6265 규격에 따라 특정 문자만 사용할 수 있다. 특히, 공백문자 사용불가.
        Cookie cookie = new Cookie("lastVisit", "minjiki2-cookie");
        cookie.setMaxAge(2 * 60 * 60); // 쿠기 유효시간 2시간
        response.addCookie(cookie); // 보내지는 http response로 보내주어야 쿠키값이 생성되어 클라이언트에게 전달됨..

        // 또다른 쿠키 추가
        Cookie cookie2 = new Cookie("user1", "admin-role");
        cookie2.setMaxAge(2 * 60 * 60); // 쿠기 유효시간 2시간
        response.addCookie(cookie2); // 보내지는 http response로 보내주어야 쿠키값이 생성되어 클라이언트에게 전달됨..

        model.addAttribute("lastVisit", lastVisit); // 쿠키가 있었다면 해당 모델값이 나오겠지요.
        model.addAttribute("user1", user1); // 파라미터에서 @CookieValue로 매핑이 되었음!!
        // request에서 쿠기값 있는지 얻어와보기
//        Cookie[] cookies = request.getCookies();
//        for (Cookie c : cookies){
//            System.out.print(c.getName() + ":::");
//            System.out.println(c.getValue());
//        }

        return "visit";
    }
}
