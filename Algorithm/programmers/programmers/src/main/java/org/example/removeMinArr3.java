package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class removeMinArr3 {
    public static void streamAPIwithCollection(){
        // 1. stream 생성
        List<String> list = Arrays.asList("a", "b", "c");

        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림

        // 2. 가공하기 - 필터링
        List<String> names = Arrays.asList("Eric", "Elena", "Java");
        Stream<String> filteringStream =
                    names.stream()
                    .filter(name -> name.contains("a")); // [Elena, Java]

        long count = filteringStream.count();
        System.out.println(count); // 2

        // 2. 가공하기 - 매핑
        Stream<String> mappingStream =
                names.stream()
                .map(str -> str.toUpperCase());

        // 대문자로 변환된 문자열을 리스트에 수집
        List<String> collectedList = mappingStream.collect(Collectors.toList());
        System.out.println(collectedList); // // [ERIC, ELENA, JAVA]

        // 3. 가공하기 - sorting
            // 1. 인자없이
        Stream<String> sortingStream1 =
                names.stream()
                .sorted();
        sortingStream1.forEach(name -> System.out.println(name));
        // sortingStream1.forEach(System.out::println); // Elena Eric Java
            // 2. Comparator 넘겨서
        Stream<String> sortingStream2 =
                names.stream()
                .sorted(Comparator.reverseOrder());
        sortingStream2.forEach(name -> System.out.println(name));
        // sortingStream2.forEach(System.out::println); //  Java Eric Elena
    }

    public static void streamAPIwithArrays(){
        String[] arr = new String[]{"a", "b", "c"};

        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamOfArrayPart =
                Arrays.stream(arr, 1, 3); // 1~2 요소 [b,c]
    }
    public static void main(String[] args) {
        // streamAPIwithArrays();
        streamAPIwithCollection();
    }
}
