package com.example.day04;

public class ArrayEx7 {
    public static void main(String[] args) {
        int[] iarr = {10,20,30,40};

        // for each 문
        for (int i : iarr){
            System.out.println(i);
        }

        System.out.println();

        for (int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }

    }
}
