package com.example.day11;

public class Bus extends Car{

    public Bus(){
        // super(); 생략하면, 자동으로 호출됨
        System.out.println("Bus() 디폴트 생성자 실행 !");
    }

    public Bus(String name){
        super(name);
        System.out.println("Bus(String name) 생성자 실행");
    }

}
