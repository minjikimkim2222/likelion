package org.day29.실습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
    3. 주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라.
    람다식을 사용하여 List의 forEach() 메서드를 활용하라.
 */
public class ListOperator {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10,20,30,40,50);
        List<Integer> newList = new ArrayList<>(intList.size());

        // 1. 익명 객체 - 인터페이스 구현
//        intList.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer element) {
//                newList.add(element + 10);
//            }
//        });
//        System.out.println(newList);

        // 2. 람다식 - java.util.function 패키지 - Consumer (입력만 받고, 반환 없음)
        intList.forEach((element) -> newList.add(element + 10));
        System.out.println(newList);
    }
}
