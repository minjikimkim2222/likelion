package org.day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("kang");
        list.add("kim");
        list.add("hong");
        list.add("lee");

        System.out.println("원래 list : " + list);
        Collections.sort(list);
        System.out.println("정렬 후 list : " + list);
    }
}
