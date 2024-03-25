package com.example.day10.util;

import java.util.Random;

public class Dice {
    private int eye; // 주사위 면 1~6으로
    private Random random = new Random();
    public int getEye() {
        return eye;
    }

    public void rollDice(){ // 주사위를 던지면, 랜덤값 1~6 중 1개로 값 변경0
        int maxDice = 6;
        int randomNum = random.nextInt(maxDice) + 1; // 1 ~ 6까지
        this.eye = randomNum;
    }
}
