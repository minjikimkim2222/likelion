package org.day23;

public class GenericMethodEx2 {
    public static <T extends Number> T max(T x, T y, T z){
        T max = x;

        if (y.intValue() > max.intValue()){
            max = y;
        }

        if (z.intValue() > max.intValue()){
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(3,5,1));
        System.out.println(max(3.2,7.7,33));
        // System.out.println(max("aaa", "bbb", "ccc")); 컴파일 에러 발생 !!!

    }
}
