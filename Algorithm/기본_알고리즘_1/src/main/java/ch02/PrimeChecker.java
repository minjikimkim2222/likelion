package ch02;

public class PrimeChecker {

    public static boolean isItPrime(int num){
        if (num <= 1)
            return false;
        for (int i = 2; i <= num-1; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 4;
        System.out.println("main - primechecker : " + PrimeChecker.isItPrime(num));
    }
}
