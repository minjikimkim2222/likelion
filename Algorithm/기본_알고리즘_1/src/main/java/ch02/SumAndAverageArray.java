package ch02;

public class SumAndAverageArray {

    public static int sumOfArrays(int[] arr){
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static double averageOfArrays(int sum, int length){
        double average = 0;

        average = (double)sum / length;
        return average;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int length = arr.length;

        int sum = SumAndAverageArray.sumOfArrays(arr);
        double average = SumAndAverageArray.averageOfArrays(sum, length);

        System.out.println("배열의 합 : " + sum + ", 평균 : " + average);

    }
}
