package org.example;

import java.util.Scanner;

/*
문제 링크 : https://www.acmicpc.net/problem/1920

같은 문제를, 순차탐색으로 풀었더니 시간초과가 떴다.
이에, 해당 문제를 이진탐색으로 풀어보겠다. -> FindNumByBinary
 */
public class FindNum {
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

        // 2. 문제 처리
        int[] answer = new int[n]; // 각 배열의 값이 존재하면 1, 존재하지 않는다면 0

        for (int keyIdx = 0; keyIdx < arrN.length; keyIdx++){
            for(int comparedIdx = 0; comparedIdx < arrM.length; comparedIdx++){
                int key = arrN[keyIdx];

                if (arrM[comparedIdx] == key){
                    answer[keyIdx] = 1;
                }
            }
        }

        System.out.println("answer 배열을 출력하자!");

        for (int temp : answer){
            System.out.println(temp);
        }



    }
}
