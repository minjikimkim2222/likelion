package org.day29.실습문제;

import java.util.Arrays;
import java.util.Comparator;

/*
    2. 주어진 정수 배열에서 최대값을 찾아 출력하라.
    람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.sort()를 활용하라.
 */
public class FindMax {
    public static void main(String[] args) {
        Integer[] intArr = {1,4,2,9,19};

//        // 1. 익명 객체
//        Arrays.sort(intArr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1; // 내림차순 정렬
//            }
//        });
//        System.out.println("최대값 : " + intArr[0]);

        // 2. 람다식
        Arrays.sort(intArr, (Integer o1, Integer o2) -> o1 - o2); // 오름차순
        System.out.println("최소값[람다] : " + intArr[0]);
        System.out.println("최대값[람다] : " + intArr[intArr.length - 1]);
    }
}
