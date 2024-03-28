package org.example;

import java.util.Arrays;

/*
https://adjh54.tistory.com/106
 */
public class SplitString_ex2 {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4};
        // 1. Arrays.copyOf(array, copyArrLength)
            // 배열 '전체'를 복사해, 복사할 길이만큼 지정해, 새로운 배열로 복사해 반환
        int[] newCopyArr = Arrays.copyOf(arr, arr.length); // 0 1 2 3 4
        // int[] newCopyArr = Arrays.copyOf(arr, 2); // 0 1
        // int[] newCopyArr = Arrays.copyOf(arr, arr.length + 3); // 0 1 2 3 4 0 0 0

        for (int i = 0; i < newCopyArr.length; i++){
            System.out.println(newCopyArr[i]);
        }

        System.out.println("또다른 테스트");

        // 2. Arrays.copyOfRange(array, startIndex, endIndex)
            // 원본 배열의 '시작인덱스'와 '끝 인덱스'를 지정해, 복사한 '새로운 배열'로 반환
        int[] newCopyArr2 = Arrays.copyOfRange(arr, 0, 2); // 0 1 (끝 인덱스 포함 X)

        for (int i = 0; i < newCopyArr2.length; i++){
            System.out.println(newCopyArr2[i]);
        }

    }
}
