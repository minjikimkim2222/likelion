package org.day29.functional_interface;

class Divide implements IntBinaryOperation {
    @Override
    public int apply(int a, int b) {
        return a/b;
    }
}
public class IntBinaryOperationTest {
    public static void main(String[] args) {
        IntBinaryOperation test = new IntBinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return 0;
            }
        };

        IntBinaryOperation test2 = (a,b) -> 0;

        IntBinaryOperation add = (a,b) -> a+b;
        IntBinaryOperation minus = (a,b) -> a-b;
        IntBinaryOperation multiply = (a,b) -> a*b;

        System.out.println(test.apply(1,2));
        System.out.println(test2.apply(3,4));
        System.out.println(add.apply(3,4));
        System.out.println(minus.apply(3,4));
        System.out.println(multiply.apply(3,4));

        // 람다함수를 역으로 인터페이스로 어떻게 구현할지도 이해하면서 알면 좋다.
        IntBinaryOperation divide = new Divide();
        System.out.println(divide.apply(8,2));

    }
}
