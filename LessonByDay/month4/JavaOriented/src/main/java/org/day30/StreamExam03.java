package org.day30;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExam03 {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("minjiki2", "23"),
                Arrays.asList("hungry", "what to eat")
        );

        System.out.println(nestedList);

        Stream<List<String>> stream = nestedList.stream();

        Stream<String> flatMapStream = stream.flatMap(strList -> strList.stream());

        List<String> resultList = flatMapStream.collect(Collectors.toList());

        System.out.println(resultList);
    }
}
