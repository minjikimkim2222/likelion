package com.example.day10.util_main;

import com.example.day10.util.Dice;
import com.example.day10.util.DiceUser;

public class DiceTest {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int totalCount = 10;
        int eye = 5;

        int count = DiceUser.diceGame(dice, totalCount, eye);

        System.out.println("주사위를 " + totalCount + "번 던져서, " + eye + "는 " +
                count + "번만큼 나왔습니다!");



    }
}
