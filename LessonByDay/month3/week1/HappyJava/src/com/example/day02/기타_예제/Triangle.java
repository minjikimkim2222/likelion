package com.example.day02.기타_예제;

public class Triangle {

    public static void main(String[] args) {
        int i = 1;
        int j;

        int count = 10; // 총 열의 개수
        while (i <= count) {
            j = 1;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
