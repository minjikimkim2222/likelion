package com.example.day03;

public class WhileEx1 {
    public static void main(String[] args) {
        int num = 1;

//        while (num <= 10){
//            if (num == 5)
//                break;
//            System.out.println("num : " + num);
//            num++;
//        }

        // 전위, 후위 증감연산자와 while문

        while (num <= 10){
//           System.out.println("num : " + num++);
            System.out.println("num : " + ++num);
        }


    }
}
