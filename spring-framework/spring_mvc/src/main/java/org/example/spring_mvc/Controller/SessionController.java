package org.example.spring_mvc.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("visitCount2")
public class SessionController {

    // HttpSession을 직접 이용한 예
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session, Model model){
//        // 세션으로부터 방문횟수를 얻어온다.
//        Integer visitCount = (Integer) session.getAttribute("visitCount");
//        //Integer visitCount = (Integer) model.getAttribute("visitCount");
//
//        System.out.println(visitCount);
//        // model.getAttribute("visitCount")를 호출했을 때 모델에 해당 속성값이 없다면, null 반환
//        // 세션도 마찬가지.
//        if (visitCount == null){
//            visitCount = 0; // 세션 처음방문시, visitCount 초기화
//        }
//        visitCount++;
//        session.setAttribute("visitCount", visitCount); // 세션에 저장해준다.
//        //model.addAttribute("visitCount", visitCount);
//        return "visit2";
//    }

    @GetMapping("/scopeTest")
    public String modelScopeTest(Model model, HttpSession session){
        //System.out.println("model ::: " + model.getAttribute("visitCount"));
        System.out.println("session ::: " + session.getAttribute("visitCount2"));
        return "visit2";
    }

    // @SessionAttributes("visitCount2") 이용..
    @ModelAttribute("visitCount2")
    public Integer initVisitCount2(){
        return 0; // 세션에 처음 들어갔을 때, 초기 방문횟수는 0..
    }
    @GetMapping("/visit2")
    public String trackVisit(@ModelAttribute("visitCount2") Integer visitCount2, Model model){
        visitCount2++; // @SessionAttributes로 visitCount2는 session scope에 저장되어 있다!
        model.addAttribute("visitCount2", visitCount2); // 모델에도 저장해 넘겨줬다.
        return "visit2";
    }

    @GetMapping("/resetVisit")
    public String resetVisit(SessionStatus status){
        status.setComplete(); // 세션을 초기화시켜줘요!
        //return "redirect:/visit2"; // 초기화시킨 뒤 redirect !
       return "forward:/visit2";
    }
}
