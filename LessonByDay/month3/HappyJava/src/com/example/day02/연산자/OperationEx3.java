package com.example.day02.연산자;

import com.example.day02.기타_예제.Book;

public class OperationEx3 {

    public static void main(String[] args){
        // 조건식 ? 반환값1 : 반환값2
        int a = 10;
        int b = 20;
        int result1 = a > b ? a : b;
        int result2 = a < b ? a : b;

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);

        // instanceof
        Book book = new Book();

        if (book instanceof Book){
            System.out.println("book은 Book클래스의 인스턴스이다.");
        }
    }
}
