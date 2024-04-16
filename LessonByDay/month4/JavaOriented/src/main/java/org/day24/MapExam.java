package org.day24;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(111, "minjiki2");
        map.put(222, "hong");
        map.put(333, "kim");

        System.out.println(map); // {333=kim, 222=hong, 111=minjiki2} ;; 순서 보장 X

        System.out.println(map.get(111));

        Set<Integer> keyset = map.keySet();
        Iterator<Integer> iter = keyset.iterator();

        while (iter.hasNext()){
            Integer key = iter.next();
            System.out.print("key : " + key);
            System.out.print(", value : " + map.get(key));
            System.out.println();
        }

        // iterator 대신 for each를 통해 key - value 꺼내올 수 있음
        for (Integer key : map.keySet()){
            System.out.print("key : " + key);
            System.out.print(", value : " + map.get(key));
            System.out.println();
        }
    }
}
