package org.example.spring_mvc.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        // 예외를 로그에 기록
        logger.error("[로그] : An error occurred ", e);
        //System.out.println(e);
        // 예외메세지를 모델에 추가
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
