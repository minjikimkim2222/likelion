package com.example.day04.실습문제;

public class DiagonalMatrixExtractor {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            firstDiagonalSum += matrix[i][i]; // 주 대각선
            secondDiagonalSum += matrix[i][size - 1 - i]; // 부 대각선
        }

        System.out.println("대각선의 합 : " + firstDiagonalSum);
    }
}
