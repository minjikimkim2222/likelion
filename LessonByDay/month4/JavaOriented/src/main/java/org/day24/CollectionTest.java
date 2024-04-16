package org.day24;

import java.util.*;
public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // 숫자 추가
        int[] numbers = {1, 2, 2, 3, 4};
        for (int num : numbers) {
            list.add(num);
            set.add(num);
        }

        // List와 Set 출력
        System.out.println("List: " + list);
        System.out.println("Set: " + set);
    }
}
