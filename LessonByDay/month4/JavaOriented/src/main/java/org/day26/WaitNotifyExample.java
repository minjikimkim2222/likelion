package org.day26;

public class WaitNotifyExample {
    private static final Object lock = new Object(); // lock이 공유자원
    private static boolean itemAvailable = false;

    static class Producer extends Thread {
        public void run() {
            synchronized (lock) {
                System.out.println("생산자가 아이템을 생산 중입니다.");
                itemAvailable = true;
                lock.notify();  // 생산이 끝났으므로 소비자에게 알림
                System.out.println("생산자가 알림을 보냈습니다.");
            }
        }
    }

    static class Consumer extends Thread {
        public void run() {
            synchronized (lock) { // lock의 소유권을 가진다.
                // 공유자원에 대해 동시에 여러 쓰레드가 접근하는 것을 막아준다. (Cosumer lock 획득)
                while (!itemAvailable) {
                    try {
                        System.out.println("소비자가 아이템을 기다리고 있습니다.");
                        lock.wait();  // 아이템을 기다림, wait하면 Cosumer가 가지던 lock의 소유권을 포기한다.
                        // wait를 만나는 순간, 현재 쓰레드 (Consumer)가 대기 상태에 있고, 다른 쓰레드에서 notify나 notifyAll을 하는 순간 깨어난다!
                        // wait를 만나는 순간, Consumer가 공유자원 lock에 대한 접근 권한을 잃었으니, 다른 쓰레드 Producer에서 접근할 수 있게 된다!
                        // Producer에서 notify를 하는 순간, Producer는 공유자원에 대한 접근 권한을 잃고, 다시 Consumer에서 접근 권한을 되찾는다!

                        // notify는 하나의 쓰레드만 깨우고, notifyAll은 모든 쓰레드를 깨운다.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("소비자가 아이템을 소비했습니다.");
                itemAvailable = false; // 아이템 소비 후 상태 업데이트
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        consumer.start(); // 소비자 스레드 시작
        try {
            Thread.sleep(1000); // 생산자 시작 전에 잠시 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start(); // 생산자 스레드 시작
    }
}
