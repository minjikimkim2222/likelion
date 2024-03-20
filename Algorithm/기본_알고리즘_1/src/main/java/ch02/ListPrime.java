package ch02;

public class ListPrime {
    // 1000 이하의 소수 list 나열, 짝수는 당연히 소수가 아니니, 제외시킬 것
    public static void listPrime(){
        int divisionCount = 0;

        for (int num = 3; num <=1000 ; num += 2){
            boolean isPrime = true; // 변수 초기화 선언 위치 중요!

            for (int divisor = 2; divisor <= num-1; divisor++){
                divisionCount++;
                if (num % divisor == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime == true){
                System.out.println(num);
            }
        }

    }

    public static void main(String[] args) {
        ListPrime.listPrime();
    }
}
