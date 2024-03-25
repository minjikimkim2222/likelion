package com.example.day04.실습문제;

public class SumAndAverageCalculator {
    public static void main(String[] args) {
        int[] scores = {70, 85, 90, 45, 100};

        int sum = 0;
        double average = 0;

        for (int i : scores){
            sum += i;
        }

        average = (double) sum / (scores.length);
        // 정수 / 정수 니까 피연산자 적어도 1개는 double형으로!

        System.out.println("배열의 합 : " + sum);
        System.out.println("배열의 평균 : " + average);
    }
}
