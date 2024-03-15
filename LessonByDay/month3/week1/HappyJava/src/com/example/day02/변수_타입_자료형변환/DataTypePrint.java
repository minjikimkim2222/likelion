package com.example.day02.변수_타입_자료형변환;

public class DataTypePrint {

    static void basic1(){
        int i = 1;

        while (i <= 100){
            System.out.println(i);
            i++;
        }
    }

    static void practice1(){
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println(a+b+c);
    }

    static void practice2(){
        char c = 'a';
        int i = 10;
        float f = (float)3.4;
        boolean isTrue = true;

        System.out.println("c : " + c);
        System.out.println("i : " + i);
        System.out.println("f : " + f);
        System.out.println("isTrue : " + isTrue);
    }

    static void practice3(){
        int x = 20;
        int doubleX = x * 2;

        System.out.println(x);
        System.out.println(doubleX);
    }

     static void primitiveAndReference() {
        int i = 0;
        String str = "my name is minjiki2";
        char c = str.charAt(1);

        Integer iInstance = 10;

        System.out.println(c);
        System.out.println(iInstance.getClass());

     }
    public static void main(String[] args){
        //basic1();
        //practice1();
        //practice2();
        //practice3();
        primitiveAndReference();

    }
}
