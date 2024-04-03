package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
프로그래머스 12935 - 정수 배열 arr 최소값 제거하는 함수 리턴
 사전 지식 : List 인터페이스, Stream api 간단 훑어보기..
 */
public class removeMinArr {
    public static int[] solution1(int[] arr){  // ArrayList 이용
        int[] resultArr;
        List<Integer> arrList = new ArrayList<Integer>();
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        if (arr.length <= 1) { // 배열 길이 1 이하
            resultArr = new int[]{-1};
            return resultArr;
        }

        Arrays.sort(arr2, (a,b) -> b-a); // 림다힘수 이용
        //Arrays.sort(arr2, Collections.reverseOrder());

        int min = arr2[arr2.length-1]; // 1


        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] != min ){
                arrList.add(arr[idx]);
            }
        }

        // 리턴타입 문제.. ArrayList가 아닌 정수배열 리턴해야 함요 ㅜㅜ
        resultArr = new int[arrList.size()];

        for (int i = 0; i < arrList.size(); i++){
            resultArr[i] = (int) arrList.get(i);
        }

        return resultArr;
    }
    public static void main(String[] args) {
        int[] test1 = {4,3,2,1};
        int[] test2 = {};
        int[] result = removeMinArr.solution1(test1);

        System.out.println("test1 테스트");
        System.out.println(Arrays.toString(result));


    }
}
