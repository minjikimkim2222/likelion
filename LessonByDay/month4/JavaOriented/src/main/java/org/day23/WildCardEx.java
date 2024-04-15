package org.day23;

import java.util.ArrayList;
import java.util.List;

public class WildCardEx {
    public static void addNumber(List<?> list){
        // list.add(1);
        // 이 코드는 컴파일 에러를 발생시킨다.
        // 왜냐하면, ?는 알 수 없는 타입이므로, 안전하지 않은 연산으로 간주한다.
    }

    public static <T> void addNumberGeneric(List<T> list, T element){
        list.add(element);
        // 이 코드는 컴파일이 성공한다.
        // T는 명확한 타입으로 간주되며, "메서드 호출 시점"에서 타입이 결정된다!!
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list); // [1,2,3
    }
}
