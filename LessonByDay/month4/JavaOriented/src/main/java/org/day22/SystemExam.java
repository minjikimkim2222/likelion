package org.day22;

public class SystemExam {
    public static void main(String[] args) {
        // 1. 환경변수 조회
        String pathVariable = System.getenv("PATH");
        System.out.println("path variable : " + pathVariable);

        // 2. 배열 복사
        int[] srcArray = {1,2,3,4,5};
        int[] destArray = new int[5];

        System.arraycopy(srcArray, 0, destArray, 0, 5);

        for (int i = 0; i < destArray.length; i++){
            System.out.println(destArray[i]);
        }
    }
}
