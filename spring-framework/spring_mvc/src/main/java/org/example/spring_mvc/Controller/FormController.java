package org.example.spring_mvc.Controller;

import jakarta.validation.Valid;
import org.example.spring_mvc.domain.User;
import org.example.spring_mvc.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form") // validation없이 단순히 form만 요청
    public String showForm(Model model){
        // 체크하고자 하는 userForm 객체를 모델로 넣어줄 것..
       model.addAttribute("userForm", new UserForm());
        return "form";
    }

    // @ModelAttribute - 쿼리파라미터/폼데이터를 자바 객체에 매핑.. (p.199)
    // 이때 주의할 점은, form 태그의 name 속성명과 모델객체(User)의 멤버변수명이 서로 일치해야 한다. 그래야 잘 찾아옴.

    // 검증결과를 받아올 bindingResult
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form"; // 유효성 검사 실패하면, 다시 form.html 뷰로 보내준다..
        }
        return "result"; // 성공했다면 result.html 이 응답.
    }
}
