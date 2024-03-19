package ch02;

import java.util.Arrays;

public class DuplicateArray {
    public static int[] change(int[] copied){
        copied[2] = 190;
        return copied;
    }

    public static int change(int orig){
        orig = 20;
        return orig;
    }

    public static void main(String[] args) {
        int[] original = {10,20,30,40,50};

        int[] copied = change(original);

        System.out.println("change(int[]) : " + copied[2]);

        int orig = 10;
        System.out.println(change(orig));

//        int[] copied = Arrays.copyOf(original, 3);
//
//        for (int i = 0; i < copied.length; i++){
//            System.out.println(copied[i]);
//        }
    }
}
