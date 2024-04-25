package org.day30;

import java.util.Arrays;
import java.util.List;

public class StreamExam06 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,2,4,5,6,3);

        boolean isPositive = integerList.stream().allMatch(n -> n > 0);
        boolean anyNegative = integerList.stream().anyMatch(n -> n < 0);
        boolean noneAboveTen = integerList.stream().noneMatch(n -> n >= 10);

        System.out.println(isPositive); // true
        System.out.println(anyNegative); // false
        System.out.println(noneAboveTen); // true
    }
}
