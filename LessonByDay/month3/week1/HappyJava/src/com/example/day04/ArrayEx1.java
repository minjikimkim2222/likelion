package com.example.day04;

public class ArrayEx1 {
    public static void main(String[] args) {
        // 1. 배열의 선언과 생성, 이용
        // 선언
        int[] iarr1;
        int iarr2[];

        // 생성
        iarr1 = new int[3];
        iarr2 = new int[5];

        // 이용
        iarr1[0] = 10;
        iarr1[1] = 20;

        System.out.println("iarr1[0] : " + iarr1[0]);
        System.out.println("iarr1[1] : " + iarr1[1]);

        String[] strArr = {"hello", "this is minji", "how are you today?"};
        System.out.println("strArr[1] : " + strArr[1]); // this is minji


        // 반복문
        int[] arr2 = {10,20,30};

        for (int i = 0; i < arr2.length; i++){
            System.out.println("arr[" + i + "] : " + arr2[i]);
        }
    }
}
