package org.day23.CollectionsEx;

import java.util.ArrayList;
import java.util.List;

public class CollectionEx01 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");

        System.out.println(strList.get(0));
        System.out.println("strList size : " + strList.size());
        System.out.println(strList.toString());

        System.out.println("**************");

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("edff");
        list.add("asdfasdf");

        for (String temp : list){
            System.out.println(temp);
        }

        System.out.println("***************");

        List<Integer> integerList = new ArrayList<>();

        integerList.add(5);
        integerList.add(4);

        System.out.println(integerList.getFirst());
        System.out.println(integerList.getLast());

        System.out.println("**************");

        integerList.add(3);
        integerList.add(3);
        System.out.println(integerList);

        integerList.clear();

        System.out.println(integerList);

    }
}
