package com.example.day10;

public class ClassARun {
    public static void main(String[] args) {

            ClassA a = new ClassA();

         //   System.out.println(a.address);
            System.out.println(a.count);
            System.out.println(a.number);
            System.out.println(a.name);

            int fieldA = ClassA.fieldA = 2;
            System.out.println("클래스 변수 - fieldA : " + fieldA);

            int fieldB = a.fieldB = 3;
            System.out.println("인스턴스 변수 - fieldB : " + fieldB);
    }
}
