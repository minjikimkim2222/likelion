package org.day29;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RambdaEx01 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("minjiki2", "23", "dinner", "what to eat");

        Consumer<String> rambaTest = new Consumer<String>() { // Consumer는 인터페이스이기에 이렇게 구현해야 함 (익명 객체)
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        // 1. 람다식 사용 전 - 정의대로
        items.forEach(rambaTest);
        // 2. 람다식 사용 후 - 람다식을 이용해, 리스트의 각 요소 출력
        items.forEach(item -> System.out.println(item));

        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("세번째 방법 : " + s);
            }
        });

        // 람다식 이전 (익명 객체) - 람다식을 이용해, 쓰레드 생성 및 실행
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 start !!");
            }
        }
        ).start();

        // 람다식 사용
        new Thread(() -> System.out.println("Thread2 start!!")).start();
    }
}
