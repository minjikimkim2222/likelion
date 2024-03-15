package com.example.day04;

import java.util.Arrays;

public class ArrayEx9 {
    public static void main(String[] args) {
        // copyOf 예제
        int[] copyFrom = {1,2,3, 4, 5, 6, 7, 8};

        int[] copyTo  = Arrays.copyOf(copyFrom, copyFrom.length);

        for (int i : copyTo){
            System.out.println(i);
        } // 1 2 3 4 5 6 7 8
        System.out.println("****************");

        copyTo = Arrays.copyOf(copyFrom, 3);

        for (int i : copyTo){
            System.out.println(i);
        } // 1 2 3

        System.out.println("****************");

        // copyOfRange 예제
        copyTo = Arrays.copyOfRange(copyFrom, 1, 3);

        for (int i : copyTo){
            System.out.println(i);
        } // 2 3

    }
}
