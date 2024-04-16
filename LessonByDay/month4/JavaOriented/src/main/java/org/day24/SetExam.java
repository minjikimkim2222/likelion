package org.day24;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set); // [a,b,c]
        set.add("a");
        System.out.println(set); // [a,b,c] --> 중복된 요소 a가 들어가지 않는 걸 확인할 수 있다!

        if (set.contains("a")){
            System.out.println("a를 포함하고 있습니다.");
        }

        set.remove("a");
        System.out.println("a 제거 후 : " + set);

        System.out.println("set 집합 크기 : " + set.size());
        Set<Pen> penSet = new HashSet<>();

        penSet.add(new Pen("red"));
        penSet.add(new Pen("black"));
        penSet.add(new Pen("blue"));

        System.out.println(penSet); // [red pen, blue pen, black pen]
        penSet.add(new Pen("red"));
        System.out.println(penSet); // [red pen, red pen, blue pen, black pen]
            // 요소의 순서 보장하지 않는다.
            // 값이 아니라 주소를 비교하기 때문에 2개의 red pen을 각기 다른 요소로 본다.
            // 하지만 만일, String인 red pen을 비교해주는 equals 함수를 오버라이딩해주면 된다 !!

            /*
                equals와 hashcode 오버라이드해주고 나면,
                [red pen, blue pen, black pen]
                [red pen, blue pen, black pen]
                으로 출력된다. 즉 중복된 요소를 허용하지 않는다!


             */
    }
}
