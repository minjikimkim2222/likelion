package org.example.day04_12;

import java.util.ArrayList;
import java.util.Collections;

/*
문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12910
 */
public class DivisibleNumberArray {
    public int[] solution(int[] arr, int divisor){
        int[] answer;

        ArrayList<Integer> arrList = new ArrayList();

        for (int i = 0; i < arr.length; i++){
            if (arr[i] % divisor == 0){
                arrList.add(Integer.valueOf(arr[i]));
            }
        }

        Collections.sort(arrList); // 오름차순 정렬

        // ArrayList to array
        if (arrList.size() == 0){
            answer = new int[]{-1};
            return answer;
        }

        answer = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++){
            answer[i] = arrList.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] test = {5,9,7,10};
        int[] test2 = {3,2,6};

        int divisor = 5;
        int divisor2 = 10;

        DivisibleNumberArray arr = new DivisibleNumberArray();
        int[] result = arr.solution(test, divisor);
        int[] result2 = arr.solution(test2, divisor2);

        System.out.println("test 원본 arr print : ");
        for (int temp : test2){
            System.out.println(temp);
        }

        System.out.println("solution 결과 후");
        for (int temp : result2){
            System.out.println(temp);
        }
    }
}
