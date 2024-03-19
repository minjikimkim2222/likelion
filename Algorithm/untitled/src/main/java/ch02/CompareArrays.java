package ch02;

import java.util.Arrays;

public class CompareArrays {

    public static boolean areArraysEqual(int[] arr1, int[] arr2){

        // return Arrays.equals(arr1, arr2);

        // 1. 두 배열의 길이 먼저 비교
        if (arr1.length != arr2.length)
            return false;

        // 2. 두 배열의 요소 비교
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i])
                return false;
        }
        // 모든 조건 통과
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {1,2,3};

        System.out.println("arr1과 arr2는 동일한가? : " + CompareArrays.areArraysEqual(arr1, arr2));
        System.out.println("arr1과 arr3는 동일한가? : " + CompareArrays.areArraysEqual(arr1, arr3));
    }
}
