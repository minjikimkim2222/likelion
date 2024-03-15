package com.example.day03;

public class IfEx1 {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a > b) {
            System.out.println("a는 b보다 크다!");
        } else {
            System.out.println("b는 a보다 크거나 같다");
        }

        // a가 짝수면 짝수입니다. 라고 출력

        if (a % 2 == 0) {
            System.out.println("a는 짝수이다.");
        } else {
            System.out.println("a는 홀수이다.");
        }

        // if문 중괄호로 묶지 않으면..
        if (a % 2 == 0) {
            System.out.println("a는 짝수이다.");
        } else
            System.out.println("a는 홀수이다.");
            System.out.println("if문이 중괄호로 묶여있지 않으면..");

        // 삼항연산자 test
        int operator3 = 10;
        int result = (operator3 > 5) ? 20 : 30;
        System.out.println("result : " + result);

    }
}
