package ch02;

import java.util.Scanner;

public class TwoDimensionalArrayEx {

    public static void inputArrays(){
        Scanner sc = new Scanner(System.in);

        System.out.println("학생 수를 입력해주세요 : ");
        int n = sc.nextInt();
        System.out.println("과목 개수를 입력해주세요 : ");
        int m = sc.nextInt();

        int[][] scores = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.println(i +"번째 학생의 " + j + "번째 점수를 입력해주세요!");
                scores[i][j] = sc.nextInt();
            }
        }

        // 이차원 배열 출력
        for (int i = 0; i < scores.length; i++){
            System.out.println(i + "번째 학생의 점수: ");
            for (int j = 0; j < scores[i].length; j++){
                System.out.println("\t" + j + "번째 점수: " + scores[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // 3명의 학생, 4과목의 점수 저장 2차원 배열

        TwoDimensionalArrayEx.inputArrays();


    }

}
