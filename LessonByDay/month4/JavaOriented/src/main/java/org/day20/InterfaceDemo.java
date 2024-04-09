package org.day20;

public class InterfaceDemo {
    public static void main(String[] args) {
        // 인터페이스도 타입이다.
        Ainter ainter = new Dimpl();
        Cinter cinter = new Dimpl();
        Dinter dinter = new Dimpl();

        // 자기가 정의한 것만 사용가능
        ainter.aMethod();
        cinter.cMethod();

        dinter.dMethod();
        dinter.aMethod();
        dinter.cMethod();

        Ainter a = new Aimpl();
        ((Aimpl)a).onlyAimpl();
        // 객체는 자기 타입까지만 접근 가능하고, '실체,인스턴스'(Aimple)에 접근하고 싶다면,
        // 해당 실체로 형변환을 시켜주면 된다!
    }
}
