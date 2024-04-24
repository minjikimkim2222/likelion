package org.day29;

public class FinalVariableExam {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("람다에서 파이널로 사용.");

        Runnable r = () -> {
            System.out.println("x : " + x);
        };

 //       x = 20; // 바깥에 있는 지역변수를 다시 재할당시키면 에러남. (사실상 final)

        r.run();
    }
}
