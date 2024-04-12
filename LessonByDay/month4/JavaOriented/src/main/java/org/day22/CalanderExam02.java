package org.day22;

import java.util.Calendar;
import java.util.Scanner;

// 연도와 월을 입력하면 날짜 형식으로 프린트하기
public class CalanderExam02 {
    public static void printCalendar(int year, int month){
        // 해당 연도, 월, 첫 번째 날짜 세팅
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1); // year, month, date

        // 마지막 날
        int lastDate = calendar.getActualMaximum(Calendar.DATE);

        // 해당 월의 첫 요일 (1: 일요일, 2: 월요일, ..., 7: 토요일)
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("일\t월\t화\t수\t목\t금\t토");

        // 첫 번째 날짜 이전의 공백 출력
        for (int i = 1; i < firstDayOfWeek; i++){
            System.out.print("   "); // 공백 출력
        }

        // 날짜 출력
        for (int day = 1; day <= lastDate; day++){
            System.out.printf("%3d ", day); // 날짜 출력 (3자리 고정)
            if ((firstDayOfWeek + day - 1) % 7 == 0){
                System.out.println(); // 토요일(7)마다 줄 바꿈
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int year = keyboard.nextInt();
        int month = keyboard.nextInt();
        CalanderExam02.printCalendar(year, month);
    }
}
