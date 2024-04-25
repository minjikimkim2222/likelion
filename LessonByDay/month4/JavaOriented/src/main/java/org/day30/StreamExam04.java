package org.day30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExam04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("minjiki2", "abc","c++", "java");

        list.stream().sorted().forEach(s -> System.out.println(s)); // 오름차순 정렬

        System.out.println("*************");
        list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).forEach(s -> System.out.println(s)); // 내림차순 정렬

        System.out.println("*************");

        list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

        // 2. 아래 배열을 오름차순, 내림차순으로 정렬해 출력
        int[] iarr = {5,3,27,9,5,9,8,4,22};

        // 위 배열을 오름차순으로 정렬해 출력
        Arrays.stream(iarr).sorted().forEach(num -> System.out.print(num + " "));

        System.out.println();
        // 위 배열을 내림차순으로 정렬해 출력 (java 제네릭 타입엔 기본형인 int가 아닌 Integer가 와야 합니다!!! )
        // Integer에 compareTo 함수가 오버라이드되어 있으니!
        Arrays.stream(iarr).mapToObj(num -> Integer.valueOf(num))
                .sorted(Comparator.reverseOrder()).forEach(num -> System.out.print(num + " "));

        System.out.println("********************2");
        // 기본데이터타입을 객체타입으로 바꿔주는 boxed
        Arrays.stream(iarr).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }).forEach(num -> System.out.print(num + " "));
    }
}
