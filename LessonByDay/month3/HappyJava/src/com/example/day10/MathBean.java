package com.example.day10;

public class MathBean {
    public void printClassName(){
        //System.out.println("MathBean");
        System.out.println(this.getClass()); // this키워드는 인스턴스 객체에만 접근 가능
        System.out.println(this.getClass().getName());
    }

    public void printNumber(int x){
        System.out.println(x);
    }

    public int getOne(){
        return 1;
    }

    public int plus(int x, int y){
        return x+y;
    }

}
