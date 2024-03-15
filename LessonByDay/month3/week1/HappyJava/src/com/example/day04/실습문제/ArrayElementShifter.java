package com.example.day04.실습문제;

public class ArrayElementShifter {
    public static void main(String[] args) {
        String[] words = {"Java", "Python", "C", "JavaScript"};

        String temp = words[words.length-1]; // temp = "JavaScript"

        for (int i = words.length-1; i >= 1; i--){
            int j = i-1;
            words[i] = words[j];
        }

        words[0] = temp;

        for (String str : words){
            System.out.println(str);
        }
    }
}
