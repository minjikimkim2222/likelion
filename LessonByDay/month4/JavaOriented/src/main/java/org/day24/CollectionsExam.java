package org.day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExam {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            list.add(i);
        }

        System.out.println("원래 list : " + list);
        Collections.shuffle(list);
        System.out.println("섞은 후 list : " + list);
        Collections.sort(list);
        System.out.println("다시 정렬한 후 list : " + list);
    }
}
