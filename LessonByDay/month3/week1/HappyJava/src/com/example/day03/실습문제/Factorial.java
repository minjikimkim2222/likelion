package com.example.day03.실습문제;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("정수 n을 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n < 0){
            System.out.println("음수값은 팩토리얼을 계산할 수 없다.");
            return;
        }

        int result = 1;
        for (int i = n; i > 1; i--){ // 1은 곱해주나마나니까, 포함안시킴
            result *= i;
        }
        System.out.println(n + "! = " + result);
    }
}
