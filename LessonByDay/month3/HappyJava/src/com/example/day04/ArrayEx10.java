package com.example.day04;

import java.util.Arrays;

public class ArrayEx10 {
    public static void main(String[] args) {
        // compare함수
        int[] arr1 = {1,2,3,4,5}; //0
//        int[] arr2 = {1,2,3,4,5}; // -1
//        int[] arr2 = {3,2,3,4,5}; // -1
        int[] arr2 = {1,2,3,4,-1}; // 1

        int result = Arrays.compare(arr1, arr2);
        System.out.println("result : " + result);

        // sort함수
        int[] arr3 = {9,7,6,2,3};
        Arrays.sort(arr3);

        for (int i : arr3){
            System.out.println(i); // 2 3 6 7 9
        }
    }
}
