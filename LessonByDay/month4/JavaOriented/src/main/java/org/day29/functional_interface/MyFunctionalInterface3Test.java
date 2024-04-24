package org.day29.functional_interface;

public class MyFunctionalInterface3Test {
    public static void main(String[] args) {
        // 1. 익명객체
        MyFunctionInterface3 inter2 = new MyFunctionInterface3() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        };
        System.out.println(inter2.sum(3,4));

        // 2. 람다식
        MyFunctionInterface3 inter3;

        inter3 = (x,y)-> {return x+y;};

        System.out.println(inter3.sum(2,3));

    }
}
