package org.example.day04_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// ArrayList 정렬하는 예제코드
public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>
                (Arrays.asList("C", "A", "B", "a"));

        System.out.println("원본 : " + arrayList);

        /// >>>>>>>>>>>>> 1. Collections.sort()
            // 오름차순으로 정렬
        Collections.sort(arrayList);
        System.out.println("1번, 오름차순 : " + arrayList);
            // 내림차순 정렬
        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println("1번, 내림차순 : " + arrayList);

        /// >>>>>>>>>>>>> 2. (java 8 이후부터) List.sort()
            // 오름차순으로 정렬
        arrayList.sort(Comparator.naturalOrder());
        System.out.println("2번, 오름차순 :" + arrayList);

            // 내림차순 정렬
        arrayList.sort(Comparator.reverseOrder());
        System.out.println("2번, 내림차순 : " + arrayList);
    }
}
