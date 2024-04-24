package org.day29;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RamdaEx02 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,2,5,7);

        // 람다식 이전 - 익명 객체
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // Integer에서 구현한 compareTo 함수 사용
            }
        });

        // 람다식 이후, 간단해진 수식
            // → 람다식을 작성할 때, 람다식 사용 전에서 구현할 함수는 어떻게 구현하는지 생각해주면 이해가 쉽다!
        Collections.sort(numbers, (Integer o1, Integer o2) -> o1.compareTo(o2));

        numbers.forEach((num) -> System.out.println(num));
    }
}
