package org.day26;

public class WaitNotifyAllExample2 {
    private static final Object lock = new Object(); // 마찬가지로 공유객체
    private static int itemsAvailable = 0;  // 사용 가능한 아이템 수

    static class Producer extends Thread {
        public void run() {
            synchronized (lock) {
                itemsAvailable += 5;  // 5개의 아이템을 생산
                System.out.println("생산자가 " + itemsAvailable + "개의 아이템을 생산하였습니다.");
                lock.notifyAll();  // 모든 대기 중인 소비자 스레드에 알림
                // notify해주면 해당 쓰레드에서는 공유자원 소유권 잃고, wait해주던 쓰레드에게 공유자원 소유권을 주는거야!!!!
                System.out.println("생산자가 모든 소비자에게 알림을 보냈습니다.");
            }
        }
    }

    static class Consumer extends Thread {
        private int id;

        Consumer(int id) {
            this.id = id;
        }

        public void run() {
            synchronized (lock) { // 공유자원에 대해 동시에 여러 쓰레드가 접근하는 것을 막아준다. (Cosumer lock 획득)
                while (itemsAvailable <= 0) {
                    try {
                        System.out.println("소비자 " + id + "가 아이템을 기다리고 있습니다.");
                        lock.wait();  // 아이템을 기다림, lock에 대한 소유권을 포기한다!
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                itemsAvailable--;  // 아이템 소비
                System.out.println("소비자 " + id + "가 아이템을 소비했습니다. 남은 아이템: " + itemsAvailable);
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer1 = new Consumer(1);
        Consumer consumer2 = new Consumer(2);
        Consumer consumer3 = new Consumer(3);

        consumer1.start(); // 소비자 1 스레드 시작
        consumer2.start(); // 소비자 2 스레드 시작
        consumer3.start(); // 소비자 3 스레드 시작

        try {
            Thread.sleep(1000); // 생산자 시작 전에 잠시 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start(); // 생산자 스레드 시작
    }

}
