package org.day21;

import java.util.Scanner;

public class ExceptionExam05 {
    // 학생의 점수를 입력받는 메서드
    public void inputScore(int score) throws MyException{

        if (score < 0 || score > 100){
//            System.out.println("점수는 0 ~ 100 사이의 값이어야 합니다!");
//            return ;
            throw new MyException("점수는 올바른 값이 아닙니다. 다시 입력해주세요.");
        }


        System.out.println(score);
    }

    public static void main(String[] args) {
        ExceptionExam05 ex = new ExceptionExam05();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("점수를 입력하세요 : ");

       try {
           ex.inputScore(keyboard.nextInt());
       } catch (MyException e){
           System.out.println(e.getMessage());
       }
        System.out.println("main 종료 !!");
    }
}

class MyException extends Exception{
    public MyException(){
        super("점수는 0 ~ 100까지만 입력받을 수 있습니다.");
    }

    public MyException(String msg){
        super(msg);
    }
}