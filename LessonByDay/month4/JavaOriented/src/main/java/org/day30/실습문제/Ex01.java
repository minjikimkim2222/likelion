package org.day30.실습문제;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        // 주어진 정수 배열에서 짝수만을 찾아, 그 합을 구하시오!

        int[] numbers = {3,10,4,17,6};

        int sum = Arrays.stream(numbers).
                filter(num -> num % 2 == 0).sum();

        System.out.println(sum);
    }
}
