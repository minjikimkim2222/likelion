package org.example;

import java.util.Scanner;

/*
또다른 풀이 - 단, 기저조건을 n == 1, n == 2, n == 3으로 설정!
 */
public class SumOneTwoThree2 {
    public static int dp(int n){
        // base 조건 - 재귀 종료 조건
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;


        int count = 0;

        count += dp(n-1);
        count += dp(n-2);
        count += dp(n-3);

        return count;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("테스트케이스 입력해주세요 : ");

        int testCount = scanner.nextInt();

        for (int idx = 0; idx < testCount; idx++){
            // System.out.println("정수 n을 입력해주세요 : ");

            int n = scanner.nextInt();
            System.out.println(dp(n));
        }

    }
}