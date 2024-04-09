package org.day20.실습문제;

public class FoodOrderTest {
    public static void main(String[] args) {
        Order pizza = new PizzaOrder();
        Order burger = new BurgerOrder();
        Payment credit = new CreditPayment();
        Payment cash = new CashPayment();

        System.out.println(">>>>>>>>>> pizza <<<<<<<<<<");
        pizza.completeOrder();
        credit.processPayment();
            // 원래 객체 credit의 타입인 Payment에 정의된 함수만 사용할 수 있는데,
            // 해당 Payment는 인스턴스라 완전히 구현된 함수가 존재하지 않는다.
            // 원래는 타입에 있는 메서드만 접근가능하고, 인스턴스(실체;CreditPayment) 객체 메서드를 사용하려면, 형변환을 해야 했다!
            // (위 내용 velog 추가) 하지만! 추상클래스와 인터페이스에서는 예외다!
        credit.finishPayment();

        System.out.println(">>>>>>>>>> burger <<<<<<<<<<");
        burger.completeOrder();
        cash.processPayment();
        cash.finishPayment();

    }
}
