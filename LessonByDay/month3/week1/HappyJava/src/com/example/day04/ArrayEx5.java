package com.example.day04;

public class ArrayEx5 {
    public static void main(String[] args) {
        int[][] iarr = new int[3][2];
        iarr[0][1] = 10;

        int[][] iarr2 = new int[3][];
        // 여기까지만 생성하면, iarr2는 3개의 1차원 배열까지밖에 없다.

        iarr2[0] = new int[4];
        // iarr2 0번째 1차원 배열에, 4개자리 int 1차원 배열의 주소를 넣어줘.
        iarr2[0][2] = 20;

    }
}
