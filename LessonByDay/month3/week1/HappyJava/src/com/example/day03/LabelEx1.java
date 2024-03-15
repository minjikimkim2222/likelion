package com.example.day03;

public class LabelEx1 {
    public static void main(String[] args) {
        anyName:
        for (int i = 0; i< 3; i++){
            for (int k = 0; k < 3; k++){
                if (i == 0 && k == 2)
                    break anyName;
                System.out.println("i : " + i + " , k : " + k);
            }
        }
        System.out.println("is it out?");
    }
}
