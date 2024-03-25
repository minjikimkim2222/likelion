package com.example.day04.실습문제;

import java.util.Arrays;

public class MinMaxFinder {
    public static void main(String[] args) {
        double[] doubles = {1.5, 3.7, 2.4, 9.8, 7.6, 3.4};

        Arrays.sort(doubles);

        System.out.println("최대값 : " + doubles[doubles.length - 1]);
        System.out.println("최소값 : " + doubles[0]);
    }
}
