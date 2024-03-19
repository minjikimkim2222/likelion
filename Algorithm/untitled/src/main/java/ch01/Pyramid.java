package ch01;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이등변삼각형 단 수를 입력해주세요!");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++){
            for (int j = n-i; j >= 0; j--){
                System.out.print(" ");
            } // 공백 먼저 출력
            // 2 * k - 1만큼 * 출력
            for (int k = 1; k <= 2*i-1; k++){
               System.out.print("*");
            }
            System.out.println();
        }
    }
}

