package com.example.day11;

public class Test2 {
    public static void main(String[] args) {
        // 1. 부모는 자식을 가리킬 수 있다!
        //    조상은 자손을 가리킬 수 있다!
        Parent parent = new Child();
        Object obj1 = new Child();
        Object obj2 = new Parent();

//        System.out.println(obj1.i);
//        System.out.println(obj1.getI());
        // 에러 발생!
        Child c = (Child)obj1;
        System.out.println(c.i);
        System.out.println(c.getI());

//     형변환은 언제만 되는데? 형변환시, instanceof로 객체가 맞는지 체킹할 것!
        byte b = 4;
        int i = b; // 묵시적 형변환

        b = (byte) i; // 명시적 형변환

        Object bbb = new Object();

        if (bbb instanceof Child) {
            Child ccc = (Child) bbb; // 조상이 자손을 가리키는 거지,
            // 자손이 조상을 가리킬 수는 없는 것임!

        }


    }
}
