package org.day29.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
    4. 주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라.
    for 루프와 람다식을 활용하여 조건에 맞는 요소를 찾아보세요.
 */
public class FindElement {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("minjiki2", "one", "four", "three");

        // input : String -> output: true/false ---> Predicate 당첨!
        Predicate<String> predicate = s -> s.length() >= 5;
        for (String str : strList){
            if (predicate.test(str)){ // 글자수가 5 이상
                System.out.println(str);
            }
            // 글자수 5 이상 아니면 그냥 넘어가기
        }
    }
}
