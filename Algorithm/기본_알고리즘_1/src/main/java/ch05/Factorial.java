package ch05;

public class Factorial {

    public static int factorialRecursive(int n){
        if (n == 0){
            return 1; // 0! == 1
        }
        else {
            return n * factorialRecursive(n-1);
        }
    }

    public static int factorialFor(int n){
        int result = 1;

        for (int i = n; i >=2; i--){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
        System.out.println(factorialFor(5));
    }
}
