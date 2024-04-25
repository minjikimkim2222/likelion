package org.day30;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExam02{
    public static void main(String[] args)  throws Exception{
        // 1. path
        Path path = Paths.get("src/main/java/org");

        Stream<Path> stream = Files.list(path); // 디렉토리 형태로 얻어올 거임

        stream.forEach(p -> System.out.println(p.getFileName()));
        stream.close();

        Stream<String> stream2 = Files.lines(Paths.get("src/main/java/org/day30/StreamExam01.java"));
        stream2.forEach(System.out::println);
        stream2.close();

        System.out.println("**************************");

        // 2. 데이터 필터링하기 - filter, distinct
        // 글자수가 5 이상인 것만 필터링하고, 중복을 제거해서 새로운 리스트로 (스트림 사용 o)
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");

        List<String> filteredWords = words.stream().filter(word -> word.length() >= 5).distinct().collect(Collectors.toList());

        System.out.println(filteredWords);
        // 스트림 사용 x
        Set<String> set = Set.copyOf(words);
        List<String> resultList = new ArrayList<>();

        for (String str : set){
            if (str.length() >= 5)
                resultList.add(str);
        }

        System.out.println(resultList);

        // 3. 데이터 변환 - map
        words.stream().map(word -> word.toUpperCase()).forEach(word -> System.out.println(word));

        System.out.println("******************");
        // 각 요소에 3을 곱해서 출력해주세요

        int[] intArr = {3,6,3,76,4,2};

        Arrays.stream(intArr).map(num -> num * 3).forEach(num -> System.out.println(num));
    }
}
