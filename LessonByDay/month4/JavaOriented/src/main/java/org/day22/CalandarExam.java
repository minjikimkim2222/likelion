package org.day22;

import java.util.Calendar;
public class CalandarExam {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);

        // 현재 날짜
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);  // month만 - 0부터 시작
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
            // 1 리턴 - 일요일
            // 2 리턴 - 월요일
            // 3 리턴 - 화요일
            // 4 리턴 - 수요일
            // 5 리턴 - 목요일
            // 6 리턴 - 금요일
            // 7 리턴 - 토요일

        System.out.println("현재 날짜 : " + year + "년 " + (month+1) + "월 " + day + "일");
        System.out.println("현재 week : " + week);

        // 특정 날짜로 설정하기
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2024, Calendar.APRIL, 13, 14, 23); // year, month, date, hour, minutues

        int year2 = calendar1.get(Calendar.YEAR);
        int month2 = calendar1.get(Calendar.MONTH);  // month만 - 0부터 시작
        int day2 = calendar1.get(Calendar.DAY_OF_MONTH);
        int hour2 = calendar1.get(Calendar.HOUR_OF_DAY);
        int minute2 = calendar1.get(Calendar.MINUTE);

        System.out.println("현재 날짜 : " + year2 + "년 " + month2 + "월 " + day2 + "일 " + hour2 + " 시간 " + minute2 + "분");

        // 날짜 추가 및 감소
        calendar1.add(Calendar.YEAR, -2);
        int updatedYear = calendar1.get(Calendar.YEAR);
        System.out.println("-2 년 : " + updatedYear);


    }
}
