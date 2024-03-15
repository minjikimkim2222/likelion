package com.example.day04;

public class ArrayEx2 {
    public static void main(String[] args) {
        // 초기값 없이
        int[] arr1; // 선언

        arr1 = new int[3];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // 초기값 있이
        int[] arr2 = new int[]{10,20,30,40};

        int[] arr3 = new int[]{33, 44, 55, 66, 77};

        // 각 배열 모두 출력
        for (int i = 0; i < arr1.length; i++){
            System.out.print("arr1[" + i + "] : " + arr1[i] + '\t');
        }
        System.out.println();

        for (int i = 0; i < arr2.length; i++){
            System.out.print("arr2[" + i + "] : " + arr2[i] + '\t');
        }
        System.out.println();

        for (int i = 0; i < arr3.length; i++){
            System.out.print("arr3[" + i + "] : " + arr3[i] + '\t');
        }
        System.out.println();
    }
}
