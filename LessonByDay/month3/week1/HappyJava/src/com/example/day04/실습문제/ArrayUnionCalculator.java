package com.example.day04.실습문제;
import java.util.Arrays;
public class ArrayUnionCalculator {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {0, 2, 4, 6, 8, 10, 3, 5};

        // 1. 두 배열을 하나로 합친다.
        int[] combinedArray = Arrays.copyOf(arr1, arr1.length + arr2.length);

        Arrays.sort(arr2);

        int index = arr1.length;

        for (int element : arr2){
            if (Arrays.binarySearch(arr1, element) >= 0){ // 중복된 요소 있음
                continue;
            }
            // 중복된 요소 없음
            combinedArray[index] = element;
            index++;
        }

        for (int i = 0; i < index; i++){ // 그냥 for each로 했더니, 초기화된 값인 0도 나와서 index까지 출력시킴
            System.out.print(combinedArray[i]);
            System.out.print(" ");
        }
    }
}
