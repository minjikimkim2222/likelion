package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/*

문제 : https://school.programmers.co.kr/learn/courses/30/lessons/181866

공백 제거를 해야 했음!

 */
public class SplitString {

    public static String[] solutionFirst(String myString){
        String[] splitString = myString.split("x"); // d cc bbb aaaa
//          System.out.println(splitString[0]); d
//          System.out.println(splitString[1]); cc
//          System.out.println(splitString[2]); bbb
//          System.out.println(splitString[3]); aaaa

        Arrays.sort(splitString);

        System.out.println("solution first test");
        for (int i = 0; i < splitString.length; i++){
            System.out.println(splitString[i]);
        }

        return splitString;
    }

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
        } // "a" "b" "c"

        String[] resultArr = resultList.toArray(new String[resultList.size()]);
        Arrays.sort(resultArr);

        System.out.println("answer 테스트");
        System.out.println(Arrays.toString(resultArr));

        return resultArr;
    }
    public static void main(String[] args) {

        // String myString2 = "dxccxbbbxaaaa"; // aaaa bbb cc d
        String myString = "axxbxcx"; // "" "a" "b" "c"

       //  SplitString.solutionFirst(myString2);

        String[] result = SplitString.solution(myString);


    }
}
