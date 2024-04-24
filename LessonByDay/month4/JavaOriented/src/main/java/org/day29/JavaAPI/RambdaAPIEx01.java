package org.day29.JavaAPI;

import java.util.function.*;

public class RambdaAPIEx01 {
    public static void main(String[] args) {
        // Predicate
        // 조건을 테스트하는데 사용.. boolean값 반환

        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(-1));

        // Consumer
        // 입력을 받고, 반환값이 없는 연산 수행
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hello minjiki2");

        // Function
        // 입력을 받고, 값을 반환
        Function<String, Integer> lengFunc = s -> s.length(); // String을 받아, Integer 리턴
        System.out.println(lengFunc.apply("minjiki2"));

        // Supplier
        // 입력 없이, 값을 반환
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());

        IntSupplier intSupplier = () -> (int)(Math.random() * 6);
        System.out.println(intSupplier.getAsInt());

        // UnaryOperator - Function extends
        // 입력과 출력이 같은 타입일 때 사용
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        // BiFunction
        // 두 개의 입력을 받고, 하나의 결과 반환
        BiFunction<Integer, Integer, Integer> minus = (x,y) -> x-y;
        System.out.println(minus.apply(2,3));

        // Consumer의 andThen 메서드 활용
        Consumer<String> conA = s -> System.out.println(s + " AAAA");
        Consumer<String> conB = s -> System.out.println(s + " BBBB");

        conA.accept("minjiki2");
        conB.accept("minjiki2");

        Consumer<String> conAB = conA.andThen(conB);
        conAB.accept("hello");

    }
}
