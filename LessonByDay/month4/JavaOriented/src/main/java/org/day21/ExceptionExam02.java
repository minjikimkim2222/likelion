package org.day21;

import java.util.Scanner;

public class ExceptionExam02 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작 !!");

        int i = Integer.parseInt(args[0]);

        try {
            System.out.println(10/i);
        } catch (ArithmeticException e)
        {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("프로그램 종료 !!");
    }
}
