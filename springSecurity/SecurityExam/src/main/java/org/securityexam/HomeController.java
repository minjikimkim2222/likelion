package org.securityexam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity
                .ok()
                .body("home");
    }

    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return ResponseEntity
                .ok()
                .body("info");
    }

    @GetMapping("/hi")
    public ResponseEntity<String> hi(){
        return ResponseEntity
                .ok()
                .body("hi");
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/fail")
    public String fail(){
        return "fail";
    }
}
