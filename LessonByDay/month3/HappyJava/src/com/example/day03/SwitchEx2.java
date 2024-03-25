package com.example.day03;

public class SwitchEx2 {
    public static void main(String[] args) {
        String str = "감자";

        switch (str){
            case "감자" :
                System.out.println("감자입니다");
                break;
            case "고구마" :
                System.out.println("고구마입니다");
                break;
            default:
                System.out.println("감자와 고구마가 아닙니다.");
        }
    }
}
