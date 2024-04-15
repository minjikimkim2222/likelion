package org.day23;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("test");
        list.add(10);
        list.add(new Exam());

        System.out.println(list);
        // 제너릭이 없었을 때는, 매번 형변환이 필요..
        String strValue = (String)list.get(0);
        Integer i = (Integer) list.get(1);

        // 제너릭 등장!!
        List<String> strList = new ArrayList<>(); // 제너릭 추가
        strList.add("abcc");
            // strList.add(10); error!! String만 들어갈 수 있기에
        String sValue = strList.get(0); // 제너릭이 있을 때는, 형변환 필요 없음
    }
}
