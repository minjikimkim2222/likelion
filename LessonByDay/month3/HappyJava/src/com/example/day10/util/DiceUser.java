package com.example.day10.util;

public class DiceUser {
    // 주사위를 n번 굴려서 나오는 눈이 eye와 같은 횟수를 보여주세요
    public static int diceGame(Dice dice, int totalCount, int eye){
        int count = 0;

        for (int i = 0; i < totalCount; i++){
            dice.rollDice();
            if (dice.getEye() == eye) {
                count++;
            }
        }

        return count;
    }
}
