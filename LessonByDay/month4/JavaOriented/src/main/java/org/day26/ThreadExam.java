package org.day26;

class MyThread extends Thread{ // 상속... Thread를 상속받은 MyThread는 Thread이다.
    @Override
    public void run() {
        // 쓰레드가 해야 하는 일
        System.out.println("myThread 출발 !!!");
        for (int i = 0; i < 10; i++){
            System.out.println("myThread 안녕 !!!");
        }
        System.out.println("myThread 종료 !!!");
    }
}
public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("main 출발 !!!");

        // 쓰레드 생성
        MyThread myThread = new MyThread();
        myThread.start(); // 약속 !!

        for (int i = 0; i < 10; i++){
            System.out.println("main 안녕 !!!");
        }

        System.out.println("main 종료 !!!");
    }
}
