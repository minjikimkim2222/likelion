package org.day26;

public class JoinExam {
    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread = new SumThread();
        sumThread.start();

        sumThread.join(); // sumThread 실행이 다 끝나고난후에야, main 쓰레드를 실행시키고 싶어!!
        System.out.println("SumThread에서 계산한 결과는 : 입니다. ");
    }
}

class SumThread extends Thread {
    @Override
    public void run() {
        System.out.println("계산했습니다!!!");
    }
}
