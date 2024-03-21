package ch06;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr){

        for (int i = 0 ; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length-1-i ; j++){ // 한번 돌면, 마지막 요소가 1번 정렬됨
                // 인접한 두 요소를 비교해서, 앞의 요소가 뒤의 요소보다 큰 값이면 교환!
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            System.out.println((i+1) + "번째 버블 정렬 : " + Arrays.toString(arr));
        }

    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {7,4,5,1,3};

        System.out.println("원래 배열 : " + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("정렬 후 배열 : " + Arrays.toString(arr));
    }


}
