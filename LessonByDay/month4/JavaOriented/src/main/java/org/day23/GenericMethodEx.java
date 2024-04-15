package org.day23;

import java.util.Date;

public class GenericMethodEx {
    public static <T> void printArrayElements(T[] arrays){
        for (T element : arrays){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5,6,7};
        printArrayElements(arr1);

        String[] arr2 = {"hello", "minjiki2", "gooooooooood"};
        printArrayElements(arr2);

        Date[] dateArr = {new Date(), new Date(2023,4,14), new Date(10000000)};
        printArrayElements(dateArr);
    }
}
