package org.day29.실습문제;

import org.day23.InterfaceEx.IntegerContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
    5. 주어진 List<Integer>의 각 요소를 제곱한 결과를 새 리스트에 저장하고 출력하라.
    for 루프와 람다식을 활용하여 각 요소를 변환하라.
 */
public class ConvertElement {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,5);
        List<Integer> newList = new ArrayList<>(integerList.size());

        Consumer<Integer> consumer = x -> newList.add(x * x);
        // input 있고, 반환값 없음 -> Consumer 당첨!
        for (Integer element : integerList){
            consumer.accept(element);
        }

        System.out.println(newList);
    }
}
