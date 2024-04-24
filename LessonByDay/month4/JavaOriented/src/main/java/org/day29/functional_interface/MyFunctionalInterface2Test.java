package org.day29.functional_interface;

public class MyFunctionalInterface2Test {
    public static void main(String[] args) {
        // 1. 익명객체 이용
        MyFunctionalInterface2 inter2 = new MyFunctionalInterface2() {
            @Override
            public void method(int x) {
                int result = x + 5;
                System.out.println(result);
            }
        };

        inter2.method(10);

        // 2. 람다식 이용
        MyFunctionalInterface2 inter3;

        inter3 = x -> {
            int result = x + 5;
            System.out.println(result);
        };

        inter3.method(20);
    }
}
