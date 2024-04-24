package org.day29.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
    6. 주어진 List<Integer>의 모든 요소가 짝수인지 확인하라.
    람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
 */
public class CheckPredicate {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5);

        // 판단 -> boolean 리턴하는 Predicate 당첨
        Predicate<Integer> predicate = x -> x % 2 == 0;

        for (Integer num : intList){
            if (predicate.test(num))
                System.out.println(num);
            // 짝수면 출력하고 아니면 말고
        }
    }
}
