package com.example.day03.기타_실습문제;

import java.util.Scanner;

public class IfExam04 {
    /*
 * 복싱체급은 몸무게가 50.80kg 이하를 "플라이급",
 * 61.23kg 이하 "라이트급", 72.57kg 이하 "미들급",
 * 88.45kg 이하 "크루저급", 그 이상을 "헤비급"이라고 하자.
 * 몸무게를 입력받아 체급을 출력하는 프로그램을 작성하시오.
입력예 : 87.3

출력예 : 크루저급
 */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner keyboard = new Scanner(System.in);
        double weight = keyboard.nextDouble();
        String weightClass;

        if (weight <= 50.80)
            weightClass = "플라이급";
        else if (weight <= 61.23)
            weightClass = "라이트급";
        else if (weight <= 72.57)
            weightClass = "미들급";
        else if (weight <= 88.45)
            weightClass = "크루저급";
        else
            weightClass = "헤비급";

        System.out.println("몸무게 : " + weight + ", 체급 : " + weightClass);
    }
}
