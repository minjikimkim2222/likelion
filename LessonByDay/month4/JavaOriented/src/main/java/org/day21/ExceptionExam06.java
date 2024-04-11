package org.day21;

import java.util.Scanner;

public class ExceptionExam06 {
    public void limitedMoneyByDay(int money) throws MyMoneyException{

        if (money < 0) {
            throw new MyMoneyException("money은 0 이상이어야 합니다!");
            //System.out.println("money은 0 이상이어야 합니다!");
        }

        if (money > 10000){
            throw new MyMoneyException("money는 10000원 이상 사용할 수 없습니다!");
            //System.out.println("money는 10000원 이상 사용할 수 없습니다!");
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        ExceptionExam06 ex = new ExceptionExam06();

        try {
            ex.limitedMoneyByDay(keyboard.nextInt());
        } catch (MyMoneyException e){
            System.out.println(e.getMessage());
        }
    }
}

class MyMoneyException extends Exception{
    public MyMoneyException(String msg){
        super(msg);
    }
}
