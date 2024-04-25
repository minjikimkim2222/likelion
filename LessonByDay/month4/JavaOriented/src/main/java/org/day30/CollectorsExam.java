package org.day30;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExam {
    public static void main(String[] args) {
        // 1. list
        List<String> strList = Arrays.asList("minjiki2", "str", "java", "python");

        List<String> resultList = strList.stream().filter(str -> str.length() >= 5).collect(Collectors.toList());

        System.out.println(resultList);

        // 2. map
        Map<String, Integer> wordsLength = new HashMap<>();
        wordsLength.put("minjiki2", "minjiki2".length());
        wordsLength.put("java", "java".length());
        wordsLength.put("python", "python".length());

        wordsLength.entrySet().stream().filter(entry -> entry.getKey().startsWith("ja")).forEach(s -> System.out.println(s));
            // entry는 Map.Entry<String, Integer> entry형이다.
            // interface Entry<K, V>에는 getValue(), getKey() .. 와 같은 메서드가 있다.

            // Map.Entry<K,V> 인터페이스는 java.util.Map 인터페이스 내부에 '중첩된 인터페이스'로 존재한다.
            // 따라서, Map.Entry<K,V> 인터페이스의 구현체는 자바의 컬렉션 프레임워크에서 제공해주는 Map 구현 클래스(HashMap..)에서 제공해준다.!



    }
}
