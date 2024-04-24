package org.day29.functional_interface;

public class MyFunctionalInterface3Test {
    public static int minus(int x, int y){
        return x-y;
    }
    public static void main(String[] args) {
        // 1. 익명객체
        MyFunctionInterface3 inter2 = new MyFunctionInterface3() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        };
        System.out.println(inter2.sum(3,4));

        // 2. 람다식 - interface 사용
        MyFunctionInterface3 inter3;

        inter3 = (x,y)-> {return x+y;};

        System.out.println(inter3.sum(2,3));

        // 3. 람다식 - minus static 함수 사용
        MyFunctionInterface3 inter4;

        inter4 = (x,y) -> {return minus(x,y);};

        System.out.println(inter4.sum(2,3)); // 실제로는 2-3 == -1

    }
}
