package com.example.day03;

import java.util.Scanner;

public class ForEx3 {
    public static void main(String[] args) {
        // 1단 구구단 출력하기
//        for (int i = 1; i <= 9; i++){
//            System.out.println("1 * " + i + " = " + 1 * i);
//        }

        // 1단 ~ 9단 구구단 출력하기
        /*
        for (int i = 1; i <= 9; i++) { // i : 몇단
            for (int j = 1; j <= 9; j++) { // j : 몇을 곱하는지
                System.out.println(i + "*" + j + " = " + i * j);
            }
        }
         */

        // 구구단 with Scanner 객체
//        System.out.println("단을 입력하세요.");
//
//        Scanner scanner = new Scanner(System.in);
//        int dan = scanner.nextInt();
//
//        for (int i = 1; i <= 9; i++){
//            System.out.println(dan + "*" + i + " = " + dan * i);
//        }

        // 입력한 n ~ 100 중, 짝수의 개수 출력하기
        System.out.println("n을 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = n; i <= 100; i++){
            if (i % 2 == 0){
                System.out.println(n + "부터 100까지 중 짝수 : " + i);
            }
        }
    }
}
