package org.day23.CollectionsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionsEx02 {

    public void addIntegerFromInput(Scanner scanner, List<Integer> arrList){

        int inputValue;
        do {
            System.out.println("정수 값을 입력해주세요 (0 제외) : ");
            inputValue = scanner.nextInt();

            if (inputValue != 0)
                arrList.add(inputValue);

        } while (inputValue != 0);
    }

    public void checkValidation(List<Integer> arrList) throws MyException{
        for (int i = 0; i < arrList.size(); i++){
            int element = arrList.get(i);

            if (element < 0 || element > 100){
                throw new MyException(element);
            }
        }
    }

    public void printResult(List<Integer> list){
        //입력된 점수를 모두 출력합니다.
        //입력된 모든 점수의 합(총점)과 평균을 계산하여 출력합니다.
        //평균은 정수로 계산하여 출력합니다.
        int sum = 0;
        double average = 0.0;

        System.out.println("입력된 모든 정수는 다음과 같습니다. ");
        for (int temp : list){
            System.out.print(temp + " ");
            sum += temp;
        }
        average = (double) sum / list.size();

        System.out.println();
        System.out.println("총점 : " + sum + ", 평균 : " + average);
    }
    public static void main(String[] args) {
        CollectionsEx02 test = new CollectionsEx02();
        List<Integer> scores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 점수 입력받기 + 0점 제거
        test.addIntegerFromInput(scanner, scores);

        // 점수 유효성 검사
        try {
            test.checkValidation(scores);
        } catch (MyException e){
            e.printStackTrace();
        }

        // 결과 출력
        test.printResult(scores);

        // 사용한 리소스 닫기
        scanner.close();
    }

}

class MyException extends Exception {
    public MyException(int score){
        super("0 ~ 100 사이의 숫자만 입력이 가능합니다!");
        System.out.println("현재 점수는 " + score + "입니다.");
    }
}