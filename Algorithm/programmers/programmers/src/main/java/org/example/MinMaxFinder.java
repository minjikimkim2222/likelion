package org.example;

public class MinMaxFinder {

    public static String solution(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String answer = "";

        String[] numStr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : numStr){
            int num = Integer.parseInt(str);

            if (num > max){
                max = num;
            }

            if (num < min){
                min = num;
            }
        }

        answer = stringBuilder.append(min).append(' ').append(max).toString();

        return answer;
    }
    public static void main(String[] args) {
        String str = "-1 -1";
        System.out.println("main : " + MinMaxFinder.solution(str));
    }
}
