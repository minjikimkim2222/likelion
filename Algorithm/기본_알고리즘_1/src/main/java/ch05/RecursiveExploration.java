package ch05;

public class RecursiveExploration {
    public static void displayPattern(int n){
        if (n == 0){
            System.out.println("return, n : " + n);
            return ;
        }
        if (n < 0)
            return ;
        displayPattern(n-1);
        System.out.println("middle, n : " + n);
        displayPattern(n-2);
    }

    public static void main(String[] args) {
        displayPattern(3);
    }
}
