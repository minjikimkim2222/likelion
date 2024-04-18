package org.day26;

class DemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("배경음악 재생중!!!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadJoinExample {
    static class TaskThread extends Thread {
        private String taskName;

        public TaskThread(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(taskName + " 작업 시작");
            try {
                Thread.sleep(2000);  // 2초 동안 스레드 일시 정지 (작업 시뮬레이션)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " 작업 완료");
        }
    }

    public static void main(String[] args) {
        TaskThread task1 = new TaskThread("작업 1");
        TaskThread task2 = new TaskThread("작업 2");

        DemonThread demonThread = new DemonThread();

        demonThread.setDaemon(true); // demonThread를 설정해, 다른 작업이 끝나면 해당 스레드의 작업도 끝나도록 설정해준다.
        demonThread.start();

        task1.start();
        task2.start();


        System.out.println("모든 작업이 완료되었습니다.");
    }
}
