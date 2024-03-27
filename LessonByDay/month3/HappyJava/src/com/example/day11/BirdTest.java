package com.example.day11;

class 새 {
    public void say() {
        System.out.println("??");
    }
}

class 참새 extends 새 {
    public void say(){
        System.out.println("짹짹");
    }
}

class 비둘기 extends 새 {
    public void say(){
        System.out.println("구구");
    }
}
public class BirdTest {
    public static void main(String[] args) {
        새 bird = null;

        if (args[0].equals("참새")){
            bird = new 참새();
        } else if (args[0].equals("비둘기")){
            bird = new 비둘기();
        } else {
            System.out.println("잘못 입력했습니다. 다시 입력해주세요!");
        }

        bird.say();
    }
}
