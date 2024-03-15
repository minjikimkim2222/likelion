package com.example.day04.실습문제;

public class ArrayReverser {
    public static void main(String[] args) {
        int[] numbers = {3,6,9,12,15};

        for (int i = numbers.length-1; i >= 0 ;i--){
            System.out.println(numbers[i]);
        }
    }
}
