package com.example.day10;

public class MathBeanRun {
    public static void main(String[] args) {
        MathBean mathBean = new MathBean();

        mathBean.printClassName();
        mathBean.printNumber(3);
        System.out.println(mathBean.getOne());
        System.out.println(mathBean.plus(2,3));

        System.out.println("Math 클래스 테스트 : " + Math.abs(-12));
    }
}
