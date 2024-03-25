package com.example.day10.util;

import java.util.Random;

public class LottoMachine {
    private int[] ball = new int[6];
    private Random random = new Random();
    public void pickLotto(){
        for (int i = 0; i < 6; i++){
            ball[i] = random.nextInt(45) + 1; // 1 ~ 45 random 뽑기
            if (!isValid(ball[i], i))
                continue;
        }
    }

    public boolean isValid(int ballNum, int limit){
        for (int i = 0; i < limit; i++){
            if (ball[i] == ballNum)
                return true;
        }
        return false;
    }

    public void printLotto(){
        for (int i = 0; i < 6; i++){
            System.out.println("ball[" + i + "] : " + ball[i]);
        }
    }
}
