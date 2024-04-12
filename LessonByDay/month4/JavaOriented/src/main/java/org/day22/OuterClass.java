package org.day22;

public class OuterClass {
    private int outerFiled = 10;

    // 내부 클래스가 마치 필드처럼 작동한다.
    private InnerClass innerClass;
    public void outerMethod(){
        // 외부 클래스 또한, 내부 클래스에 접근 가능
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    class InnerClass{
        public void innerMethod(){
             // 내부 클래스가, 외부 클래스의 필드에 접근이 가능하다!
            System.out.println("outerField = " + outerFiled);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod(); // outerField = 10
    }
}

