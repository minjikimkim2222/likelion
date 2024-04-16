package org.day24;

import java.util.*;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        // for문과 get 메서드로, 리스트 요소에 순차적인 접근
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 하지만 순서가 존재하지 않는 set과 같은 컬렉션은 iterator를 이용해 순차적인 접근이 가능해졌다!
        Set<String> set = new HashSet<>();

        set.add("a2");
        set.add("b2");
        set.add("c2");

        Iterator<String> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        // for each문 사용 - java version 5
        for (String str : set){
            System.out.println(str);
        }

    }
}
