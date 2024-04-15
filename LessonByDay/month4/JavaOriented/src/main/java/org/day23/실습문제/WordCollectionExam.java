package org.day23.실습문제;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCollectionExam {

    public static void inputStrings(Scanner scanner, ArrayList<String> arrList){
        // 사용자가 "quit"를 입력할 때까지 반복해서, 단어를 입력받는다.
        // 입력받은 단어는 ArrayList<String>에 저장된다!
        // quit는 arrList에 들어가지 않는다!
        while (true){
            System.out.println("문자열을 입력해주세요 (quit를 입력하면, 종료) : ");
            String inputString = scanner.nextLine(); // 줄 단위로 String 입력받음

            if (inputString.equals("quit"))
                return ;
            arrList.add(inputString);
        }
    }

    public static void printResult(ArrayList<String> arrList){
        // 입력받은 모든 단어 출력
        // 모든 단어의 개수와 글자 수의 합을 계산해 출력
        // 단어 중, 가장 긴 단어와 그 길이를 출력한다.

        int countWord = 0; // 단어 개수
        int countCharacters = 0; // 글자 총 개수
        int[] eachWordCount = new int[arrList.size()]; // 각 단어의 길이를 저장할 배열
        int maxWordLength = 0; // 가장 긴 단어 길이
        int idx = 0; // 가장 긴 단어를 가진 arrList의 idx

        for (int i = 0; i < arrList.size(); i++){
            countWord++;
            countCharacters += arrList.get(i).length();
            eachWordCount[i] = arrList.get(i).length();

            if (eachWordCount[i] > maxWordLength) {
                maxWordLength = eachWordCount[i];
                idx = i;
            }
        }

        System.out.println("입력받은 모든 단어는 다음과 같습니다. ");
        for (String temp : arrList){
            System.out.print(temp + " ");
        }
        System.out.println();

        System.out.println("모든 단어의 개수 : " + countWord + ", 모든 글자 수의 합 : " + countCharacters);
        System.out.println("가장 긴 단어 : " + arrList.get(idx) + ", 가장 긴 단어의 길이 : " + maxWordLength);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrList = new ArrayList<>();

        inputStrings(scanner, arrList);

        printResult(arrList);
    }
}
