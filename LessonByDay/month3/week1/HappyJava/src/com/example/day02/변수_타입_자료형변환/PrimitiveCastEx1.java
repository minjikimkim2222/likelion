package com.example.day02.변수_타입_자료형변환;

public class PrimitiveCastEx1 {

    public static void main(String[] args){
        // 묵시적 형변환 vs 명시적 형변환
        byte b = 10;
        int i = b; // 묵시적 형변환 (크기가 큰 타입은, 작은 타입을 저장할 수 있다.)

        b = (byte)i; // 명시적 형변환 (크기가 작은 타입을, 작은 타입에 저장하려면 형변환을 해줘야 한다.)


        // 실수값을 정수에 저장하려면, 명시적 형변환을 해야 한다.
        //      -> 실수값에는 소수값이 있지만, 정수는 없어서
        int i1 = (int)50.0;
        int i2 = (int)25.6f;

        System.out.println("i1 : " + i1 + ", i2 : " + i2);
    }
}
