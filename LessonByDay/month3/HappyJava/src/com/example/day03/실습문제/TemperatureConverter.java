package com.example.day03.실습문제;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // 변환 공식은 F = C * 9/5 + 32

        System.out.println("섭씨온도(C)를 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        double C = scanner.nextDouble();

        double F = (C * 9/5) + 32;
        System.out.println("변환된 화씨온도 : " + F);

        // 왜 int가 아닌 double을 썼을지?

        System.out.println("9/5 : " + 9/5);
        System.out.println("9.0/5 : " + (9.0/5));

        System.out.println("36.0 * 9/5 : " + 36.0 * (9/5));
        System.out.println("36 * 9/5 : " + 36 * (9/5));
    }
}
