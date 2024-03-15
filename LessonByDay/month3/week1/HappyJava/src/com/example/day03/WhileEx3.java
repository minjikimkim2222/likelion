package com.example.day03;

public class WhileEx3 {
    public static void main(String[] args) {
        // 1 ~ 10 사이에 있는 짝수만 출력하세요
        int i = 0;

        while (i < 10){
            if (i % 2 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

    }
}
