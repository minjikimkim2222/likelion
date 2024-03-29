package org.example;

import java.util.ArrayList;

public class SplitString_ex3_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("first");
        arrayList.add(1,"second");
        arrayList.add("third");
        arrayList.add(0, "꼽사리");
        arrayList.add("");

        System.out.println(arrayList.get(1));

        System.out.println(arrayList.toString());

        arrayList.remove(2);
        System.out.println(arrayList);
    }
}
