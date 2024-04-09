package org.day20.실습문제;

public interface Payment {
    void processPayment();

    default void finishPayment(){
        System.out.println("음식 주문에 대한 결제가 완료되었습니다!");
    }
}

class CreditPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("신용카드로 결제되었습니다.");
    }
}

class CashPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("현금으로 결제되었습니다.");
    }
}