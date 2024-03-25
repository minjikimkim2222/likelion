package com.example.day04;

public class ArrayEx8 {
    public static void main(String[] args) {
        ItemForArray[] item = new ItemForArray[3];

        item[0] = new ItemForArray(1000, "사과");
        item[1] = new ItemForArray(7700, "Waffle");
        item[2] = new ItemForArray(10000, "곱창");

        for (ItemForArray i : item){
            System.out.println(i.getName());
            System.out.println(i.getPrice());
        }

    }
}
