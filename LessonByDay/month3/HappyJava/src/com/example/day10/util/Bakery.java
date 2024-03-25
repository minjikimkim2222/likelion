package com.example.day10.util;

public class Bakery {
    private int currentBreadNum; // 현재 빵 개수

    private int currentBeverageNum; // 현재 음료 개수

    public Bakery(int currentBreadNum, int currentBeverageNum){
        this.currentBreadNum = currentBreadNum;
        this.currentBeverageNum = currentBeverageNum;
    }
    public void howManyBread(int breadNum){ // 남은 빵 개수
        if (breadNum <= currentBreadNum) {
            this.currentBreadNum -= breadNum;
            System.out.println("Bread purchased!");
        } else {
            System.out.println("Sorry, no more breads...");
        }
    }

    public void howManyBeverage(int beverageNum) { // 남은 음료 개수
        if (beverageNum <= currentBeverageNum) {
            this.currentBeverageNum -= beverageNum;
            System.out.println("Beverage purchased!");
        } else {
            System.out.println("Sorry, no more beverages...");
        }
    }

    public int countSellProducts(){
        return currentBeverageNum + currentBreadNum;
    }

    public void printStatus(){
        System.out.println("현재 남은 빵 개수 : " + this.currentBreadNum);
        System.out.println("현재 남은 음료 개수 : " + this.currentBeverageNum);
    }
}
