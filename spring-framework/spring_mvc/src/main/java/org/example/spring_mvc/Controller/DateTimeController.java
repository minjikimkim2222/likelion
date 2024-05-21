package org.example.spring_mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.time.*;

@Controller
public class DateTimeController {
    @GetMapping("datetime")
    public String showDatetime(Model model){
        // 날짜 및 시간데이터
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        // 모델에 데이터 추가
        model.addAttribute("currentDate", date);
        model.addAttribute("currentDatetime", dateTime);
        model.addAttribute("currentTime", time);
        model.addAttribute("currentZonedDateTime", zonedDateTime);

        return "datetime"; // Thymeleaf 템플릿 이름
    }
}
