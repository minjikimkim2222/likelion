package com.example.day11;

public class Car {
    String name;
    int speed;

    public Car(){
        // 디폴트 생성자
        System.out.println("car의 디폴트 생성자 호출");
    }

    public Car(String name){
       // this.name = name;
        this(name, 0);
    }

    public Car(String name, int speed){
        this.name = name;
        this.speed = speed;
    }
}
