package com.example.day10.util;

public class BreadLover {
    private Bakery baker_Lee;

    // 이 생성자 안 만들어줬다가, baker_lee 가 null이라도 에러 뜸!
    public BreadLover(Bakery baker_Lee){
        this.baker_Lee = baker_Lee;
    }

    public void buyBread(int breadNum){
        baker_Lee.howManyBread(breadNum);
    }

    public void buyBeverage(int beverageNum){
        baker_Lee.howManyBeverage(beverageNum);
    }
}
