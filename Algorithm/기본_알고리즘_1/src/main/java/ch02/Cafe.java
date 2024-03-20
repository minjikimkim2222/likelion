package ch02;

import java.time.LocalTime;

public class Cafe {
    private String coffeeName;
    private String desertName;

    private LocalTime openTime;

    private LocalTime closedTime;

    // 디폴트 생성자
    public Cafe(){

    }

    public Cafe(String coffeeName, String desertName, LocalTime openTime, LocalTime closedTime){
        this.coffeeName = coffeeName;
        this.desertName = desertName;
        this.openTime = openTime;
        this.closedTime = closedTime;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setDesertName(String desertName) {
        this.desertName = desertName;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public void setClosedTime(LocalTime closedTime) {
        this.closedTime = closedTime;
    }

    public void printCafeInfo(){
        System.out.println("커피 이름 : " + this.coffeeName);
        System.out.println("디저트 이름 : " + this.desertName);
        System.out.println("카페 오픈 시간 : " + this.openTime);
        System.out.println("카페 마감 시간 : " + this.closedTime);
    }

}
