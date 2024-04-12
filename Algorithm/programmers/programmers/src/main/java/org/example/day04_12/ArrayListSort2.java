package org.example.day04_12;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort2 {
    public static void main(String[] args) {
        // >>>>>>>>>>>> 3. Comparable 인터페이스로 사용자 정의 객체 정렬 방식
            // Collections.sort()는 객체 정렬할 때, 해당 객체의 Comparable을 구현한 compareTo() 메서드를 참조해, 정렬순서 결정
        ArrayList<Fruit> arrList = new ArrayList<>();

        arrList.add(new Fruit("apple", 2000));
        arrList.add(new Fruit("orange", 3000));
        arrList.add(new Fruit("banana", 1000));
        System.out.println("원본 : " + arrList);

        // "price 순" 오름차순 정렬
        Collections.sort(arrList);
        System.out.println("3번, 오름차순 : " + arrList);

        // "price 순" 내림차순 정렬
        Collections.sort(arrList, Collections.reverseOrder());
        System.out.println("3번, 내림차순 : " + arrList);


    }
}

class Fruit implements Comparable<Fruit>{
    private String name;
    private int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // >>>>>>>>>>>>> compareTo 함수 오버라이드!
    @Override
    public int compareTo(Fruit fruit) {
        if (this.price > fruit.price){
            return 1; // 양부 반환
        } else if (this.price < fruit.price){
            return -1; // 음수 반환
        }
        return 0; // 0 반환
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}