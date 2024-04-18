package org.day26;

class MyRunnable implements Runnable { // MyRunnable은 Thread는 아니다.
    @Override
    public void run() {
        System.out.println("myRunnable 출발 !!!");
        for (int i = 0; i < 10; i++){
            System.out.println("myRunnable 안녕 !!!");
        }
        System.out.println("myRunnable 종료 !!!");
    }
}

class Minjiki2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Minjiki2 출발 !!!");
        for (int i = 0; i < 10; i++){
            System.out.println("Minjiki2 안녕 !!!");
        }
        System.out.println("Minjiki2 종료 !!!");
    }
}
public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("main 출발 !!!");

        // 쓰레드 생성
            // MyRunnable은 자체가 Thread가 아니기에, Thread를 만들어야 함
        Thread runnableThread = new Thread(new MyRunnable());
        Thread minjiki2Thread = new Thread(new Minjiki2());

        runnableThread.start(); // 약속 !!
        minjiki2Thread.start();

        for (int i = 0; i < 10; i++){
            System.out.println("main 안녕 !!!");
        }

        System.out.println("main 종료 !!!");
    }
}
