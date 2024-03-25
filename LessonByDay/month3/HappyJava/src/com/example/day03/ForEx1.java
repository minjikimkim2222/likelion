package com.example.day03;

public class ForEx1 {
    public static void main(String[] args) {
        // *을 10번 출력
        /*
        for (int i = 0; i < 10; i++)
            System.out.println("*");

         */

        // 1 ~ 100까지 짝수의 합 구하기
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("sum : " + sum);

        // 1 ~ 100까지의 홀수 합
        int sum2 = 0;

        for (int i = 1; i <= 100; i++){
            if (i % 2 == 1)
                sum2 += i;
        }
        System.out.println(sum2);
    }
}
