package ch06;

import java.util.Arrays;

/*
배열 -> 항상 인덱스랑 배열원소를 구분하지 않거나, 배열의 범위를 벗어나서 틀림
 */
public class SelectionSort {

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            int minIdx = i;
            for (int j = i+1; j < arr.length ; j++){
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }

    }
    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {9,6,7,3,5};

        System.out.println("원래 배열 : " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("정렬 후 배열 : " + Arrays.toString(arr));
    }

}
