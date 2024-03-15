package com.example.day03.실습문제;

import java.util.Scanner;

public class ParityChecker {
    public static void main(String[] args) {
        
            System.out.println("정수 n을 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            if (num % 2 == 0)
                System.out.println(num + "은 짝수입니다.");
            else
                System.out.println(num + "은 홀수입니다.");
        }
    }

