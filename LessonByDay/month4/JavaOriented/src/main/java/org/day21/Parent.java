package org.day21;

public class Parent {
    public final void print(){
        System.out.println("parent - print()");
    }
}

 class Child extends Parent {

     // 오버라이딩 불가능!
//    @Override
//    public void print() {
//        super.print();
//    }
}
