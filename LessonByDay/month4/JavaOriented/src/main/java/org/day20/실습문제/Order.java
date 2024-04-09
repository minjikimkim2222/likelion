package org.day20.실습문제;

public abstract class Order {
    // 음식 주문 관련, 공통적인 특성 + 메서드
    final void completeOrder(){
        prepareFood();
        serveFood();
        System.out.println("주문이 완료되었습니다!");
    }

    abstract void prepareFood();
    abstract void serveFood();
}

class PizzaOrder extends Order {
    @Override
    void prepareFood() {
        System.out.println("pizza를 준비하겠습니다.");
    }

    @Override
    void serveFood() {
        System.out.println("pizza를 서빙하겠습니다.");
    }
}

class BurgerOrder extends Order {
    @Override
    void prepareFood() {
        System.out.println("Burger를 준비하겠습니다.");
    }

    @Override
    void serveFood() {
        System.out.println("Burger를 서빙하겠습니다.");
    }
}