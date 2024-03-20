package org.example;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 링크 : https://www.acmicpc.net/problem/1920

이진탐색을 사용하려면, 정렬이 전제조건이다!

 */
public class FindNumByBinary {
    public static void main(String[] args) {
        // 1. 입력받기
        Scanner scanner = new Scanner(System.in);

        System.out.println("n을 입력해주세요 : ");
        int n = scanner.nextInt();

        int[] arrN = new int[n];

        System.out.println("arr[n] 배열값들을 차례로 입력해주세요!");
        for (int i = 0; i < arrN.length; i++){
            int value = scanner.nextInt();
            arrN[i] = value;
        }

        System.out.println("m을 입력해주세요 : ");
        int m = scanner.nextInt();

        System.out.println("arr[m] 배열값들을 차례로 입력해주세요!");

        int[] arrM = new int[m];
        for (int i = 0; i < arrM.length; i++){
            int value = scanner.nextInt();
            arrM[i] = value;
        }

        // 2. 문제처리
        int[] answer = new int[m]; // 각 배열의 값이 존재하면 1, 존재하지 않는다면 0

        for (int i = 0; i < answer.length; i++){
            answer[i] = 1; // 모든 answer값 1로 초기화
        }

        // arrN 정렬!
        Arrays.sort(arrN);
        // 탐색부분을 이진탐색으로 수정!
        for (int keyIdx = 0; keyIdx < arrM.length; keyIdx++){

            int key = arrM[keyIdx];

            int result = Arrays.binarySearch(arrN, key);

            if (result < 0) {
                answer[keyIdx] = 0;
            }
        }

        System.out.println("answer 배열을 출력하자!");

        for (int temp : answer){
            System.out.println(temp);
        }
    }
}
