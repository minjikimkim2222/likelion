package org.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExam01 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("aeesd", "bee", "cat", "dog", "a2");

        // filter 매개변수 - Predicate, collect - 반환된 스트림을 리스트로!
        List<String> filteredList = strList.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());

        System.out.println(filteredList);

        // 스트림을 모른다면??
        List<String> resultList = new ArrayList<>(strList.size());

        for (String str : strList){
            if (str.startsWith("a"))
                resultList.add(str);
        }

        System.out.println(resultList);

        // name을 몽땅 다 출력하고 싶다!
        String[] names = {"minjiki2", "kim", "lee", "kang"};

        for (String name : names){
            System.out.println(name);
        }

        // 스트림을 이용해봐라! - forEach 매개변수가 Consumer
        Arrays.stream(names).forEach(name -> System.out.println(name));

        Arrays.stream(names).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // int 배열 예제 - 짝수만 출력
        int[] arr = {1,2,3,4,5,6,7,8};

        Arrays.stream(arr).filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));

    }
}
