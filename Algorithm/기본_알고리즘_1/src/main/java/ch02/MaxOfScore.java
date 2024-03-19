package ch02;

import java.util.Scanner;

public class MaxOfScore {

    // 정수배열을 입력받아 최대값을 리턴하는 메서드
    public static int findMaxValue(int[] arr){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 학생 수를 입력받고, 학생 수만큼 정수를 입력받아서, 정수배열을 리턴하는 함수
    public static int[] inputStream(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("학생 수를 입력해주세요 : ");
        int studentNum = scanner.nextInt();

        int[] arr = new int[studentNum];

        for (int i = 0; i < studentNum; i++){
            System.out.println("arr[" + i + "]번째 값을 입력해주세요");
            arr[i] = scanner.nextInt();
        }

        return arr;
    }
    public static void main(String[] args) {

        int[] arr1 = {20, -1, 3, 42, 33};

        System.out.println("max값 " + MaxOfScore.findMaxValue(arr1));

        System.out.println("inputStream 함수 테스트해보자");
        int[] resultArr = MaxOfScore.inputStream();

        for (int i = 0; i < resultArr.length; i++){
            System.out.println(resultArr[i]);
        }
    }
}
