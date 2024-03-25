package com.example.day10;

public class VendingMachine {

    public String pushProductButton(int menuId){
        if (menuId == 1)
            return "콜라";
        else if (menuId == 2)
            return "사이다";
        else if (menuId == 3)
            return "당근케이크";
        else
            return "햄버거";
    }

    public static void printVersion(){
        System.out.println("자판기 ver 3.25");
    }
}
