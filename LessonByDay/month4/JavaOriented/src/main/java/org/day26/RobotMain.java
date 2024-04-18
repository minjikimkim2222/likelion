package org.day26;

/*
    문제 설정 - methodA와 methodB를 동시에 작동시키면, 로봇은 고장난다!
        단, methodC는 언제 오든지 상관없다.

    RobotPlayer는 Thread이다
        각 RobotPlayer(Thread)마다 동일한 '공유' 자원인 Robot 클래스를 사용한다.
        그런데 '문제 설정'에서, method A와 method B에 동시에 접근하면 고장난다고 했다.

    Robot은 공유자원이다. - RobotPlayer(thread)에서 동시에 사용할 수 있는 공유자원이기 때문

    3개의 thread기(playerA, playerB, player C; RobotPlayer)가 동시에 접근하면 안되는 methodA, methodB에
    synchronized 동기화키워드를 붙인다. [문제 설정]
    그렇게 되면, methodA와 methodB 중, (상황에 따라 다름) 만일 먼저 method A가 공유자원(Robot)에 접근했다면,
    synchronized가 붙은 method B는 공유자원(Robot)에 접근 못하고 대기한다.
    (이때, synchronized가 붙지 않는 method C는 접근이 가능하다)
 */
class Robot {
    public synchronized void methodA(){
        for (int i = 1; i <= 5; i++){
            System.out.println("method A : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void methodB(){
        for (int i = 1; i <= 5; i++){
            System.out.println("method B : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void methodC(){
        for (int i = 1; i <= 5; i++){
            System.out.println("method C : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class RobotPlayer extends Thread {
    private String name;
    private Robot robot; // Thread를 extends한 RobotPlayer가 동시에 사용하는 '공유자원'

    public RobotPlayer(String name, Robot robot){
        this.name = name;
        this.robot = robot;
    }

    @Override
    public void run() {
        if (name.equals("A")){
            robot.methodA();
        } else if (name.equals("B")){
            robot.methodB();
        } else {
            robot.methodC();
        }
    }
}
public class RobotMain {
    public static void main(String[] args) {
        Robot robot = new Robot(); // 공유자원 객체 생성

        RobotPlayer threadA = new RobotPlayer("A", robot); // threadA 생성
        RobotPlayer threadB = new RobotPlayer("B", robot); // threadB 생성
        RobotPlayer threadC = new RobotPlayer("C", robot); // threadC 생성

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
