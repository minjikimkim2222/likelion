package org.day30;

import java.util.ArrayList;
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

        // flatmap 2차 예제
        List<String> strList = Arrays.asList("hello minjiki2", "age 23", "year 02", "love soccer");
        strList.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(s -> System.out.println(s));

        System.out.println("*******************");

        List<String> list2 = Arrays.asList("1 , 3,  5, 7  ,9, 11, 13");
        list2.stream()
                .flatMapToInt(
                        data -> {
                            String[] splitArr = data.split(",");
                            int[] intArr = new int[splitArr.length];

                            for (int i = 0; i < splitArr.length; i++){
                                intArr[i] = Integer.parseInt(splitArr[i].trim());
                            }

                            return Arrays.stream(intArr); // flatMap이 중간연산이니까 stream을 리턴해줘야 되는 거야!
                        }
                ).forEach(s -> System.out.println(s));

        System.out.println("***************");
        list2.stream().flatMapToInt(data -> Arrays.stream(data.split(","))
                        .mapToInt(str -> Integer.parseInt(str.trim())))
                .forEach(System.out::print);

    }
}
