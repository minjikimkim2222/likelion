package com.example.day11;

public class Test1 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.i); // 5
        System.out.println(parent.getI()); // 5

        Child child1 = new Child();
        System.out.println(child1.i); // 5
        System.out.println(child1.getI()); // 5

        // 아무것도 상속받지 않으면, 자동으로 java.lang.Object를 상속받는다.
        System.out.println(parent.toString());
        System.out.println(parent.getClass().getName());

        System.out.println(child1.getClass().getName());

    }
}
