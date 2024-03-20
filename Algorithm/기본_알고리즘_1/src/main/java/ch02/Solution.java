package ch02;

public class Solution {
    public static int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++){
            answer[i] = countArray(strlist[i]);
        }
        return answer;
    }

    public static int countArray(String arr){
        return arr.length();
    }

    public static void main(String[] args) {
        String[] strlists = {"We", "are", "the", "world"};
        Solution.solution(strlists);
    }
}
