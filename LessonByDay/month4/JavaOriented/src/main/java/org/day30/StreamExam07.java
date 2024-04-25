package org.day30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class StreamExam07 {
    public static void main(String[] args) {
        int[] intArr = {1,3,5,7,77,33,19};

        int max = Arrays.stream(intArr).boxed().
                max(Integer::compareTo).orElse(-1);
        // max의 러턴값 Optional<T>, 그리고 Optional클래스에서 제공해주는 orElse 메서드
        // orElse - list가 비어있다면 -1 출력해주세요

        int min = Arrays.stream(intArr).boxed().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).orElse(-1);

        long count = Arrays.stream(intArr).count();

        double average = Arrays.stream(intArr).average().orElse(0.0);

        int sum = Arrays.stream(intArr).sum();

        System.out.println("count : " + count);
        System.out.println("max : " + max);
        System.out.println("min : " + min);
        System.out.println("average : " + average);
        System.out.println("sum : " + sum);

        // OptinalInt
        OptionalInt minOptional = Arrays.stream(new int[]{1,2,3,4,5})
                .filter(n -> n % 2 == 0)
                .min();
        if (minOptional.isPresent()) {
            int asInt = minOptional.getAsInt();
            System.out.println("min even num : " + asInt);
        } else
            System.out.println("no even numbers found");
    }
}
