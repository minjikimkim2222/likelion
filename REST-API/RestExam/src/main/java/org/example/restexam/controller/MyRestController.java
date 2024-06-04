package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {

    @GetMapping("/api/greeting")
    public Map<String, String> greet(@RequestParam(name = "name", required = false, defaultValue = "World!!") String name){
        Map<String, String> response = new HashMap<>();

        response.put("message", "Hello, " + name);
        return response;
        // 반환되는 자바 객체를, json 기반의 HTTP response Body로 변환시킨다.
    }

    @GetMapping(value = "/productxml/{id}", produces = "application/xml")
    public Product getProductXml(@PathVariable Long id){
        return new Product(id, "Example Product", 10.1);
    }

    @GetMapping(value = "/productjson/{id}", produces = "application/json")
    public Product getProductJson(@PathVariable Long id){
        return new Product(id, "Example Product", 10.1);
    }


}
