package com.example.day10.util_main;


import com.example.day10.util.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.plus(2,3));
        System.out.println(calculator.minus(2,3));
    }
}
