package org.example.day04_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort3 {
    public static void main(String[] args) {
        // >>>>>>>>>>>> 3. Comparator 인터페이스로 사용자 정의 객체 정렬 방식
        // Collections.sort()는 객체 정렬할 때, 해당 객체의 Comparator을 구현한 compare() 메서드를 참조해, 정렬순서 결정
        ArrayList<FruitNew> arrList = new ArrayList<>();

        arrList.add(new FruitNew("apple", 2000));
        arrList.add(new FruitNew("orange", 3000));
        arrList.add(new FruitNew("banana", 1000));
        System.out.println("원본 : " + arrList);

        // "price 순" 오름차순 정렬
        Collections.sort(arrList, new FruitByPrice());
        System.out.println("4번, 오름차순 : " + arrList);

        // "price 순" 내림차순 정렬
        Collections.sort(arrList, new FruitByPrice().reversed());
        System.out.println("4번, 내림차순 : " + arrList);
    }
}

class FruitByPrice implements Comparator<FruitNew> {

    @Override
    public int compare(FruitNew f1, FruitNew f2) {
        if (f1.getPrice() > f2.getPrice())
            return 1;
        else if (f1.getPrice() < f2.getPrice())
            return -1;
        else
            return 0;

    }
}

class FruitNew {
    private String name;
    private int price;

    public FruitNew(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
