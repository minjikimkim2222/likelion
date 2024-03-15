package com.example.day03.실습문제;

import java.util.Scanner;

public class PositiveSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int positiveNum;
        int sum = 0;

        do {
            System.out.println("양의 정수를 입력하세요.");
            positiveNum = scanner.nextInt();

            sum += positiveNum;
        } while (positiveNum != 0);
        System.out.println("입력받은 양수의 총합 : " + sum);
    }
}
