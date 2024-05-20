package org.example.spring_mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public String name(){
        return "home"; // @Controller는 뷰를 리턴하기 때문에, 문자열 "home"을 리턴하는 것이 아니라, 뷰 이름 "home"을 리턴..
    }

    @GetMapping(value = "/aboutMe")
    public String aboutMe(){
        return "aboutMe";
    }

    @GetMapping("/bread")
    public String breadLover(){
        return "bread";
    }

    // rest - @ResponseBody 추가..
    @ResponseBody
    @GetMapping("rest")
    public String rest(){
        return "restBody test !!!";
    }

    @GetMapping("greeting")
    public String greet(@RequestParam(name="name", required = false, defaultValue = "min") String name,
                        @RequestParam(name="age", defaultValue = "20") int age, Model model){
        // http://localhost:8080/greeting?name=minjiki2&age=23
        // 쿼리문자열 : ?name=minjiki2@age=23
        System.out.println("name : " + name); // 콘솔에 name : minjiki2
        System.out.println("age : " + age); // 콘솔에 age : 23 이 찍힌 것을 확인할 수 있었음..

        // 이때 얻은 값을..view에 넘겨서 쓰고 싶어
        // 컨트롤러에서 model을 생성해 얻은 값을 넣어주면, view에서 컨트롤러에서 넣은 값을 model을 통해 접근할 수 있다..
        // 이때, model에 값이 어느정도로 길게 유지되냐면, model scope는 디폴트로 request scope와 동일하기에,
        //  model이 add된 특정 url("greeting")에서만 유지된다.. 만일, request url이 달라져도 필요한 값이면, session scope에 저장해주면 됨

        model.addAttribute("name", name); // model Key-"name", value = name - minjiki2

        return "greeting";
    }

    @GetMapping("greeting-mv")
    public ModelAndView greet(@RequestParam String name, ModelAndView modelAndView){
        System.out.println(name);

        // modelAndView는 비슷한데, model과 view를 한꺼번에 가진 객체를 리턴해주는 방식,,
        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");

        return modelAndView;
    }
}
