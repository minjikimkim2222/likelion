package org.day30;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam05 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        // forEach 사용 예제
            numbers.stream().forEach(s -> System.out.println(s));

        // peek 사용 예제
            List<Integer> plusArr = numbers.stream().peek(n -> System.out.println("processing 1 : " + n))
                    .map(num -> num + 2)
                    .peek(n -> System.out.println("processing 2 : " + n))
                    .collect(Collectors.toList()); // processing 1,2 다 된 다음에 collect(최종연산)이 되는 중간연산 peek!

        System.out.println(plusArr);
    }
}
