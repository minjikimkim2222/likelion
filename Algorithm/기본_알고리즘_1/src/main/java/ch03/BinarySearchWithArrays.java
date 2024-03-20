package ch03;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchWithArrays {

    public static int binarySearchwithArrays(int[] arr, int key) {

        Arrays.sort(arr);

        int idx = Arrays.binarySearch(arr, key);
        return idx;
    }
    public static void main(String[] args) {
        
        int[] arr = {-9, 0, 1, 4, 12, 23};
        int key = 23;

        int idx = binarySearchwithArrays(arr, key);

        if (idx < 0){
            System.out.println("찾는 인덱스 값은 존재하지 않습니다.");
        }
        else {
            System.out.println(key + "값의 인덱스는 " + idx + "입니다.");
        }

    }
}
