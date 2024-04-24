package org.day29.실습문제;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    1. 주어진 List<String>을 문자열 길이에 따라 정렬하되, 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
 */
public class SortList {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("minjiki2", "one", "hello world", "java");

        // 1. 익명 객체
//        Collections.sort(strList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        System.out.println(strList);

        // 2. 람다식
        Collections.sort(strList, (s1, s2) -> s1.length() - s2.length());
        System.out.println(strList);
    }
}
