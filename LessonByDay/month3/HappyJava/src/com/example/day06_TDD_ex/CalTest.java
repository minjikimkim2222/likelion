package com.example.day06_TDD_ex;

public class CalTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int result = cal.sum(10,20);

        System.out.println(result);

        System.out.println(cal.sum(3,5));

        System.out.println(cal.minus(3,5));
    }
}
