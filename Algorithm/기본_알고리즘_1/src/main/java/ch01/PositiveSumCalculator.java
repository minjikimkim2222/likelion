package ch01;

import java.util.Scanner;

public class PositiveSumCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("양수를 입력해주세요");
            n = scanner.nextInt();

            if (n >= 0)
                break;
            System.out.println("음수입니다. 양수를 다시 입력해주세요");
        }

        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += i;
        }
        System.out.println("1부터 n까지의 합 : " + sum);

    }
}
