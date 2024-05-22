package org.example.spring_mvc.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping("/start")
    public String startProcess(Model model, HttpServletRequest request){
        model.addAttribute("forwardTest", "minjiki2");
        System.out.println("model:::: " + model.getAttribute("forwardTest"));
        System.out.println("request::::" + request.getAttribute("forwardTest"));
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(Model model, HttpServletRequest request){
        System.out.println("model:::: " + model.getAttribute("forwardTest"));
        System.out.println("request::::" + request.getAttribute("forwardTest"));
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("redirectTest", "tree");
        System.out.println("redirectModel ::::: " + model.getAttribute("redirectTest"));
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination(Model model){
        System.out.println("redirectTest :::::: " + model.getAttribute("redirectTest"));
        return "redirectPage";
    }
}
