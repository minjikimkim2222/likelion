package org.day22;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeExam {
    public static void main(String[] args) {
        // 현재 날짜와 시간 가져오기
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("현재 날짜 : " + date);
        System.out.println("현재 시간 : " + time);
        System.out.println("현재 날짜와 시간 : " + dateTime);

        System.out.println();
        // 특정 날짜와 시간 설정 + formatter
        LocalDate date2 = LocalDate.of(2024, 4, 12);
        LocalTime time2 = LocalTime.of(15, 39);
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 4,12,15,39);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("특정 날짜 : " + date2);
        System.out.println("특정 시간 : " + time2);
        System.out.println("특정 날짜와 시간 : " + dateTime.format(formatter));

        System.out.println();
        // zonedDateTime
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("현재 날짜와 시간(시간대 포함) : " + now);

        // 다른 시간대로 변환하기
        ZonedDateTime nowInNewYork = now.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("현재 시간(뉴욕) : " + nowInNewYork);

        System.out.println();
        // Duration example
        LocalTime start = LocalTime.of(9,0);
        LocalTime end = LocalTime.of(13,0);

        Duration duration = Duration.between(start, end);
        System.out.println("duration : " + duration);
        System.out.println("duration.toHours() : " + duration.toHours() );

        // Period example
        LocalDate startDate = LocalDate.of(2024,4,12);
        LocalDate endDate = LocalDate.of(2026,1,1);

        Period period = Period.between(startDate, endDate);

        System.out.println("기간: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일");


    }
}
