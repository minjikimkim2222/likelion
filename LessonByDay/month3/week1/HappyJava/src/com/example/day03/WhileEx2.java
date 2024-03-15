package com.example.day03;

public class WhileEx2 {
    public static void main(String[] args) {
        // 1 ~ 100까지의 짝수의 합 구해주세요.
        int num = 1;
        int sum = 0;

        while (num <= 100){
            if (num % 2 == 0)
                sum += num;
            num++;
        }
        System.out.println("sum : " + sum);

    }
}
