package com.example.day03.실습문제;

public class MultiplicationTablePrinter {
    public static void main(String[] args) {
        for (int i = 2; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                System.out.printf("%d * %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
