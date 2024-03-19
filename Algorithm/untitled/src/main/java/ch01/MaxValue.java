package ch01;

public class MaxValue {
    // 메서드
    public static int findMax(int a, int b, int c){
        int maxValue = a;

        if (b > maxValue)
            maxValue = b;

        if (c > maxValue)
            maxValue = c;

        return maxValue;
    }

    // main
    public static void main(String[] args) {
        System.out.println(MaxValue.findMax(2,3,4));
        System.out.println(findMax(2,2,2));
        System.out.println(findMax(7,-1,100));
    }
}
