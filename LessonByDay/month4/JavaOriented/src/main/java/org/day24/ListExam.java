package org.day24;

import java.util.*;

public class ListExam {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        // add
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        // 접근 - get
        String getFruit = fruits.get(0);
        System.out.println("첫번째 과일 : " + getFruit);

        // 요소 수정 - set
        fruits.set(1, "blue berry");

        // 요소 삭제 - remove
        fruits.remove("cherry");

        System.out.println("업데이트된 과일 리스트 : " + fruits); // 업데이트된 과일 리스트 : [apple, blue berry]

        // iterator를 이용해 요소 출력
        Iterator<String> iter = fruits.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        // LinkedList test
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("linkedlist - peek : " + ((LinkedList<Integer>) linkedList).peek());
        System.out.println(linkedList.get(0));

        System.out.println("linkedlist - for each");
        for (int temp : linkedList){
            System.out.println(temp);
        }

        // Collections
        System.out.println("!!! Collections 예제 시작 !!!");
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("셔플 전, list : " + integerList);
        Collections.shuffle(integerList);
        System.out.println("셔플 후, list : " + integerList);
        Collections.sort(integerList);
        System.out.println("셔플된 리스트 정렬 후 : " + integerList);
    }
}
