package com.example.day04;

public class ArrayEx4 {
    public static void main(String[] args) {
        // 배열의 길이
        int[] arr1 = new int[5];

        System.out.println(arr1.length); // 5

        // main -String[] args 가져오기
            // java Hello 10 20 30
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
    }
}
