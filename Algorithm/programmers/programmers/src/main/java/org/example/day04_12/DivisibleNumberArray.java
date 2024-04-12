package org.example;
/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DivisibleNumberArray {
//    public int[] solution(int[] arr, int divisor){
//
//
//    }
    public static void main(String[] args) {
        int[] test = {5,9,7,10};
        int[] test2 = {3,2,6};

        int divisor = 5;
        int divisor2 = 10;

        DivisibleNumberArray arr = new DivisibleNumberArray();
        //int[] result = arr.solution(test, divisor);
        // int[] result2 = arr.solution(test2, divisor2);

        System.out.println("test 원본 arr print : ");
        for (int temp : test){
            System.out.println(temp);
        }
    }
}
