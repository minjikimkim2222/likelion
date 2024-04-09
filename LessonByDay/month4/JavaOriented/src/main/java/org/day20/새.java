package org.day20;

abstract public class 새 {
    abstract public void 노래하다();
}

class 비둘기 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("구구");
    }
}

class 까치 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("깍깍");
    }
}

class 참새 extends 새 {
    @Override
    public void 노래하다() {
        System.out.println("짹짹");
    }
}

abstract class 앵무새 extends 새 {
    abstract public void 말하다();
}

class 앵무새2 extends 앵무새 {
    @Override
    public void 노래하다() {
        System.out.println("새 추상 클래스 - 노래하다 오버라이딩");
    }

    @Override
    public void 말하다() {
        System.out.println("앵무새 추상 클래스 - 오버라이딩");
    }
}