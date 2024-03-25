package com.example.day04;

public class ArrayEx6 {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];

        arr[0][0] = 0;
        arr[0][1] = 1;
        arr[0][2] = 2;

        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[1][2] = 5;

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }

//        int[] iarr = {1, 23, 3};
//        int[][] iarr2 = {{1,2}, {3,4}};
//
//        System.out.println("iarr2[0][1] : " + iarr2[0][1]); // 2
//        System.out.println("iarr2[1][0] : " + iarr2[1][0]); // 3
//
//        int[][] iarr3 = {{1,23,4}, {1}, {1,3,4}};
//        System.out.println(iarr3[0][1]); // 23
//        System.out.println(iarr3[1][0]); // 1
//        System.out.println(iarr3[2][1]); // 3

    }
}
