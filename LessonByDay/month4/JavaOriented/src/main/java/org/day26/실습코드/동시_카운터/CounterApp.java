package org.day26.실습코드.동시_카운터;

// 각 스레드가 독립적으로 실행되기에 (공유자원도 없기에) 동기화 메커니즘을 필요하지 않습니다 !!
// 단순한 쓰레드 생성 문제
    // 두 쓰레드가 각각 자기 작업을 하려고 계속 다투는 것을 확인할 수 있다!
    // Runnable interface에서도 Thread의 'static' 메서드 sleep 사용 가능
class IncrementCounter implements Runnable{
    // 1 ~ 100까지 숫자를 증가시키며, 각 숫자를 콘솔에 출력

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++){
            System.out.println("Increment : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DecrementCounter implements Runnable{
    // 100 ~ 1까지 숫자를 감소시키며, 각 숫자를 콘솔에 출력

    @Override
    public void run() {
        for (int i = 100; i > 0; i--){
            System.out.println("Decrement : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class CounterApp {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter());
        Thread decrementThread = new Thread(new DecrementCounter());

        System.out.println("main 시작");
        incrementThread.start();
        decrementThread.start();
        System.out.println("main 종료");
    }
}
