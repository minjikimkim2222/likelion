package com.example.day03.실습문제;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomAnswer = random.nextInt(100) + 1;
        int howManyTries = 1;

        while (true){
            System.out.println("1 ~ 100까지 숫자 중 임의의 값을 추측해보세요!");
            int guessNumber = scanner.nextInt();

            if (guessNumber == randomAnswer)
                break;
            else if (guessNumber > randomAnswer)
                System.out.println("정답보다 큽니다.");
            else
                System.out.println("정답보다 작습니다.");
            howManyTries++;
        }
        System.out.println("총 " + howManyTries + "횟수만에 정답 " + randomAnswer +"를 맞췄습니다!");


    }

}
