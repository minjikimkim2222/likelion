package org.day29.functional_interface;

class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void method1() {
        System.out.println("[impl 클래스] : method1 called");
    }

//    @Override
//    public void method2() {
//        System.out.println("[impl 클래스] : method2 called");
//    }
}
public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterfaceImpl();

        myFunctionalInterface.method1();
//        myFunctionalInterface.method2();

        MyFunctionalInterface myFunctionalInterface1 = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("[익명객체] : method1 called");
            }

//            @Override
//            public void method2() {
//                System.out.println("[익명객체] : method2 called");
//            }
        };

        myFunctionalInterface1.method1();
//        myFunctionalInterface1.method2();

        // 3. 람다식 사용
        MyFunctionalInterface myFunctionalInterface3 = () -> System.out.println("[람다식] : method1");
            // method1 override 중
            // 람다 표기시, 인터페이스에 메서드가 1개를 가졌을 때만 가능!! (method2 주석 처리)
        myFunctionalInterface3.method1();

    }
}
