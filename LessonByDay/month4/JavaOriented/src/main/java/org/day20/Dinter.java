package org.day20;

public interface Dinter extends Cinter, Ainter{
    // 자바는 클래스끼리는 다중상속이 안되지만, 인터페이스 간에는 다중 상속이 가능하다.
    public void dMethod();
}
