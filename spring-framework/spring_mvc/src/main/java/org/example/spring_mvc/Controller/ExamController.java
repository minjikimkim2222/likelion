package org.example.spring_mvc.Controller;

import org.example.spring_mvc.domain.Item;
import org.example.spring_mvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {

    @GetMapping("/viewResolver")
    public String testViewResolver(){
        return "my-prefix";
    }
    @GetMapping("/guest/{name}")
    public String guest(@PathVariable String name){
        System.out.println(name);
        return "redirect:/datetime";
    }

    @GetMapping("/userTest")
    public String test(@RequestParam(name = "id") String userId){
        System.out.println("userId : " + userId);
        return "redirect:/datetime";
    }
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "Welcome to our great website !!");

        List<Item> items = Arrays.asList(
                new Item("크림와플", 2300),
                new Item("햅쌀와플", 3000),
                new Item("크로플", 2400)
        );

        model.addAttribute("itemList", items);

        return "welcome";
    }

    // url = /products 요청하면
    // products를 이용해서 상품 목록이 출력되도록 템플릿 작성해주세요. (footer도 잘 나오게)
    @GetMapping("/products")
    public String showProductsPage(Model model){

        List<Product> products = Arrays.asList(
          new Product(1, "Apple", 1.20),
          new Product(2, "Banana", 0.75),
          new Product(3, "Cherry", 2.05)
        );

        model.addAttribute("productList", products);
        return "product";
    }

    @GetMapping("/example")
    public String showExam(Model model){
        model.addAttribute("username", "minjiki2");
        model.addAttribute("isAdmin", false);
        model.addAttribute("languages", new String[]{"Korean", "English", "German"});

        return "exam";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<String> items = Arrays.asList(
          "Item one", "Item two", "Item three", "Item four", "Item five",
                "Item six", "Item seven", "Item eight", "Item nine", "Item ten"
        );

        model.addAttribute("items", items);
        return "list";
    }
}