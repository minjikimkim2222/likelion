package org.day23;

import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    // 하한을 사용해, 제너릭 메서드 정의
    public static void addNumbers(List<? super Integer> list){
        for (int i = 1; i <= 5; i++){
            list.add(i); // Integer도 물론 추가 가능
        }
    }

    public static void main(String[] args) {
        // Integer의 자기자신, 또한 부모 혹은 조상들이 올 수 있다 !!
        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(integerList);
        addNumbers(numberList);
        addNumbers(objectList);

        System.out.println("integer List : " + integerList);
        System.out.println("number List : " + numberList);
        System.out.println("object List : " + objectList);
    }
}
