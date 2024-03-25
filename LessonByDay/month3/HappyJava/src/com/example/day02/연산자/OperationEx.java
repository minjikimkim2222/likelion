package com.example.day02.연산자;

public class OperationEx {

    public static void main(String[] args){
        // 예제 1
        boolean flag1;

        flag1 = (10 != 5);
        System.out.println("flag1 : " + flag1);

        // 예제 2
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;

        flag2 = (10 > 5) && (5 < 20);
        flag3 = (10 > 5) & (5 < 20);
        flag4 = (10 >= 10) || (5 > 6);
        flag5 = (10 >= 10) | (5 > 6);

        System.out.println("flag2 : " + flag2);
        System.out.println("flag3 : " + flag3);
        System.out.println("flag4 : " + flag4);

        // 예제 3 - 2개짜리 논리연산자는 필요에 따라, 바로 앞의 논리식만 계산할 수 있지만
        //         1개짜리 비트연산자는 무조건 뒤에 있는 연산자까지 같이 실행해줘야 한다.
        int a = 10;
        System.out.println(a > 10 && a++ < 20);
        System.out.println("a : " + a);

        int b = 10;
        System.out.println(b > 10 & b++ < 20);
        System.out.println("b: " + b);
    }
}
