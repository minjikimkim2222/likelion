package org.day30.실습문제;

import javax.print.DocFlavor;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {
    public static void main(String[] args) {
        // 문자열 리스트 필터링 - 길이가 5 이상인 문자열만을 선택해 대문자로 변환하고, 결과를 리스트로 반환
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elephant");
        List<String> resultList = new ArrayList<>();

        resultList = words.stream().filter(str -> str.length() >= 5).map(str -> str.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(resultList);


    }
}
