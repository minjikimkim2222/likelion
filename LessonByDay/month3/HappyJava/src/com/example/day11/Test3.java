package com.example.day11;

public class Test3 {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.i); // 5
        System.out.println(p.getI()); // 5

        Child c = new Child();
        System.out.println(c.i); // 10
        System.out.println(c.getI()); // 10

        // 2. 필드는 오버라이딩되면, 타입을 따른다.
        // **3. 메서드는 오버라이딩되면, 무조건!!! 자식을 따른다! **
        Parent pc = new Child();
        System.out.println(pc.i); // 5 -> pc는 자기 pc의 i == 5밖에 모름
        System.out.println(pc.getI()); // 10
    }
}
