package ch01;

public class MiddleValue {
    public static int findMiddle(int a, int b, int c){
        int midValue = 0;

        if (a >= b){
            if (b >= c){
                midValue = b;
            }
            else if (a <= c){
                midValue = a;
            }
            else
                midValue = c;
        }
        else {
            if (a >= c){
                midValue = a;
            }
            else if (b > c){
                    midValue = c;
            }
            else
                midValue = b;
        }
        return midValue;
    }
}
