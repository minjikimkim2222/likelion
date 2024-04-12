package org.day22;

public interface Greeter {
    void greet();
}

class GreeterMain {
    public static void main(String[] args) {
        // 익명 객체를 사용해 Greeter 인터페이스 구현
        Greeter morningGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println("좋은 아침입니다!!");
            }
        };

        Greeter eveningGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println("좋은 저녁입니다!!!");
            }
        };

        morningGreeter.greet();
        eveningGreeter.greet();
    }
}