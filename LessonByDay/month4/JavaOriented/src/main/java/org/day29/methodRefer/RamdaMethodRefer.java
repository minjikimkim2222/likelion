package org.day29.methodRefer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class RamdaMethodRefer {
    public static void main(String[] args) {
        // 메소드참조 ::
        // 1. 정적 메서드 참조
        BiFunction<Integer, Integer, Integer> maxFunc = (a,b) -> Math.max(a,b);
        BiFunction<Integer, Integer, Integer> maxFunc2 = Math::max;

        System.out.println(maxFunc.apply(3,5));

        // 2. 인스턴스 메서드 참조
        String str = "Hello, minjiki2";
        Supplier<Integer> lengthFunc = () -> str.length();
        Supplier<Integer> lengthFunc2 = str::length;

        System.out.println(lengthFunc.get());
        System.out.println(lengthFunc2.get());

        // 3. 임의 객체의 인스턴스 메서드 참조
        List<String> words = Arrays.asList("minjiki2", "dinner", "what to eat?", "only");
        List<Integer> lengths = new ArrayList<>();

        Function<String, Integer> lengthFun = String::length;

        for (String word : words){
            lengths.add(lengthFun.apply(word));
        }

        System.out.println(lengths);

        // 4. 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;


        List<String> listStr = listSupplier.get();
        listStr.add("hello");
        listStr.add("minjiki2");
        listStr.add("23");

        System.out.println(listStr);


    }
}
