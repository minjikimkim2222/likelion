package com.example.day04;

public class ArrayEx3 {
    public static void main(String[] args) {
        ItemForArray[] item1 = new ItemForArray[5];
        ItemForArray[] item2;
        item2 = new ItemForArray[5];

        item1[0] = new ItemForArray(1000, "pencil");
        item1[1] = new ItemForArray(2000, "pencil2");
        item1[2] = new ItemForArray(3000, "pencil3");

        item2[3] = new ItemForArray(5000, "banana");

        ItemForArray[] item3 = {new ItemForArray(6000, "bread"), new ItemForArray(10000, "치킨")};

        System.out.println("item1입니다.");
        for (int i = 0; i < 3; i++){
            System.out.print(i + "번째 " + item1[i]);
            System.out.print(", " + item1[i].getName());
            System.out.print(", " + item1[i].getPrice());
            System.out.println();
        }

        System.out.println();
        System.out.println();

        System.out.println("item2입니다.");

        System.out.println("item2[3] : " + item2[3]);
        System.out.println("price : " + item2[3].getPrice() + ", name : " + item2[3].getName());

        System.out.println();
        System.out.println();

        System.out.println("item3입니다.");

        for (int i = 0; i < 2; i++){
            System.out.print(i + "번째 " + item3[i]);
            System.out.print(", " + item3[i].getName());
            System.out.print(", " + item3[i].getPrice());
            System.out.println();
        }
    }
}
