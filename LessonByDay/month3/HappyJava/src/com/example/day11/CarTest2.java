package com.example.day11;

class Car2 {
    String brand; // 브랜드
    String model; // 모델
    int year; // 연식

    public Car2(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    void displayInfo(){
        System.out.println("브랜드 : " + brand);
        System.out.println("모델 : " + model);
        System.out.println("연식 : " + year);
    }
}

class ElectricCar extends Car2 {
    int batteryCapacity; // 배터리 용량

    public ElectricCar(String brand, String model, int year, int batteryCapacity){
        super(brand, model, year); // Car2 클래스의 생성자 호출
        this.batteryCapacity = batteryCapacity;

    }
    void displayInfo(){
        System.out.println("e - 브랜드 : " + this.brand);
        System.out.println("e - 모델 : " + this.model);
        System.out.println("e - 연식 : " + this.year);
        System.out.println("e - 배터리 용량 : " + this.batteryCapacity);
    }
}
public class CarTest2 {
    public static void main(String[] args) {
        Car2 car = new Car2("Hyundai", "Sonata", 2020);
        ElectricCar car2 = new ElectricCar("Tesla", "Model S", 2021, 75);

        car.displayInfo();
        car2.displayInfo();
    }
}
