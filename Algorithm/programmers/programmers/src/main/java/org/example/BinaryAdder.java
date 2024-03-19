package org.example;

/*
문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/120885

하드코딩 실패! -> 계속 고민하다가, Integer 클래스 발견해서 풀었다.
 */
public class BinaryAdder {
    public String solution(String bin1, String bin2) {
        String answer = "";

        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);

        int sumOfNums = num1 + num2;

        answer = Integer.toBinaryString(sumOfNums);

        return answer;
    }
    public static void main(String[] args) {
        BinaryAdder binaryAdder = new BinaryAdder();

        System.out.println("result 결과 : " + binaryAdder.solution("10", "11"));
    }
}
