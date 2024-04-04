package org.example;

// 프로그래머스 12915

import java.util.Arrays;

/*
    ["sun, "bed", "car"]
    1. n번째 인덱스를 추출해, 문자열 맨앞에 두고, 그뒤에 원래 문자열을 더해준다.
        n == 1
        ["usun", "ebed", "acar"]
    2. 위 문자열 배열을 정렬해준다.
        ["acar", "ebed", usun"]
    3. 첫번째 문자를 제외한 문자열 배열을 리턴해준다.
        ["car", "bed", "sun"] --> subString

    // 2. 자바 공식문서
        java.lang -> String 클래스 -> 멤버함수 api 체킹

 */
public class StringSort {

    public static void stringAPITest(){
        // 1. concat 함수 테스트
        String str = "abc";
        String result = str.concat("def");

        System.out.println("result : " + result); // abcdef
        System.out.println("str : " + str); // abc
            // concat 함수 주의할 점!! 원본 str은 변하지 않고, 반환해준 문자열이 이어진 거임!!

        // 2. char to String conversion
        char ch = 'a';
        String charToString = Character.toString(ch);

        // 1 + 2
        System.out.println("test!");
        System.out.println(str.concat(charToString)); //abca
        System.out.println("str : " + str); // abc
            // 얘도 concat함수처럼, 원본 str은 변하지 않고, 반환해준 문자열이 연결된 거임!!

        // 3. subString
        String test = "ebed";

        String result2 = test.substring(0,2); // 시작인덱스 포함, 끝 인덱스 제외
        System.out.println("test str : " + test); // ebed
        System.out.println("result2 : " + result2); // eb
            // 얘도 앞선 함수들처럼, 원본 문자열은 그대로, 반환해준 문자열이 부분문자열임!

    }
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++){
           // System.out.println(strings[i]);
            char ch = strings[i].charAt(n);
            String chToString = Character.toString(ch); // concat 함수 사용을 위한 준비
            answer[i] = chToString;
        }

        // "u" "e" "a"
        for (int i = 0; i < answer.length; i++){
            answer[i] = answer[i].concat(strings[i]);
        }
            // 여기서 concat할 때 값을 다시 할당해줘야, 이어붙인 애들이 적용이 된다!

        // "usun". "ebed", "acar"

        // 2. 문자열 배열 정렬하기
        Arrays.sort(answer); // "acar" "ebed" "usun"

        for (int i = 0; i < answer.length; i++){
            answer[i] = answer[i].substring(1, answer[i].length());
        } // "car" "bed" "sun"

        return answer;
    }

    public static void main(String[] args) {
        String[] test1 = {"sun", "bed", "car"};
        String[] test2 = {"abce", "abcd", "cdx"};

        int n = 2;

        StringSort.solution(test2, n);

        //  StringSort.stringAPITest();
    }
}
