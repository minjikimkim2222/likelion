package com.example.day04;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(plus(1, 2, 3));
        System.out.println(plus(1, 2));
        System.out.println(plus(1, 2, 3, 4));
    }

    public static int plus(int... args){
        int sum = 0;

        for (int i = 0; i < args.length; i++){
            sum += args[i];
        }
        return sum;

    }
}
