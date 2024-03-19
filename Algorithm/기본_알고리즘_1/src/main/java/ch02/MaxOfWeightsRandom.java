package ch02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfWeightsRandom {

    public static int maxOf(int[] weights){
        int max = weights[0];

        for (int i : weights){
            if (i > max)
                max = i;
        }
        return max;
    }
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("몸무게 최대값을 구하자");
        System.out.println("사람 수 : ");
        int num = scanner.nextInt();

        int[] weights = new int[num];

        for (int i = 0; i < num; i++){
            weights[i] = 40 + random.nextInt(60);
            // 0 ~ 59까지 난수 생성 -> 40 ~ 99까지의 난수 생성;
            System.out.println("weights[" + i + "] : " + weights[i]);
        }
        System.out.println("최대 몸무게 : " + MaxOfWeightsRandom.maxOf(weights));
    }

}
