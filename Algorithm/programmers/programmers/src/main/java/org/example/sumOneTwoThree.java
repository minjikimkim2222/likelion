package org.example;

import java.util.Scanner;

/*
문제 -> https://www.acmicpc.net/problem/9095

정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램

큰 문제를 작은 문제 여러 개로 쪼개 푸는 DP 이용 (구현 - 재귀)

D(n) : 정수 n을 1,2,3의 합으로 나타내는 방법의 '개수' 라 할 때, 다음의 식을 세울 수 있다.
-> D(n) = D(n-1) + D(n-2) + D(n-3)

-> ex
        4 == 3 + 2 + 1
        D(4) == D(3) + D(2) + D(1)
          이때, D(1)은 1을 1,2,3의 합으로 만드는 방법의 개수로 1,
               D(2)는 (1+1, 2) -> 2개
               D(3)은 (1+1+1. 1+2, 2+1, 3) -> 4개
          따라서, D(4) = 7개와 동일

 */
public class sumOneTwoThree {

    public static int countSumofNum(int n){
        // base 조건 - 재귀 종료 조건
        if (n == 0)
            return 1; // 합이 완성된 경우
        if (n < 0)
            return 0; // 합을 완성할 수 없는 경우

        int count = 0;

        count += countSumofNum(n-1);
        count += countSumofNum(n-2);
        count += countSumofNum(n-3);

        return count;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("테스트케이스 입력해주세요 : ");

        int testCount = scanner.nextInt();

        for (int idx = 0; idx < testCount; idx++){
            // System.out.println("정수 n을 입력해주세요 : ");

            int n = scanner.nextInt();
            System.out.println(countSumofNum(n));
        }

    }
}
