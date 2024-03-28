package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/*

문제 : https://school.programmers.co.kr/learn/courses/30/lessons/181866

공백 제거를 해야 했음!

 */
public class SplitString {

    public static String[] solution(String myString){

        String[] splitString = myString.split("x"); // "" "a" "b" "c"
        ArrayList<String> resultList = new ArrayList<>();

//        System.out.println(splitString[0]);
//        System.out.println(splitString[1]);
//        System.out.println(splitString[2]);
//        System.out.println(splitString[3]);

        for (String temp : splitString){
            if (!temp.equals("")){
                resultList.add(temp);
            }
        }

        String[] resultArr = resultList.toArray(new String[resultList.size()]);
        Arrays.sort(resultArr);

//        for (int i = 0; i < splitString.length; i++){
//            System.out.println(i + "번째 str : " + splitString[i]);
//        }

        System.out.println("answer 테스트");
        System.out.println(Arrays.toString(resultArr));

        return resultArr;
    }
    public static void main(String[] args) {

        // String myString = "axbxcxdx";
        // String myString = "dxccxbbbxaaaa";
        String myString = "xaxbxcx";

        String[] result = SplitString.solution(myString);


    }
}
