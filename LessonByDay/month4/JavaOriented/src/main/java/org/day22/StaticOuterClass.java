package org.day22;

/*
static하지 않은 것 -> static 접근; 가능! (static은 인스턴스화 되기 전에 미리 만들어진 애들이니깐)
static한 것 -> static하지 않은 것 접근; 가능! (static이 먼저 만들어진 애들인데, 지금 인스턴스화되어 만들어져있는지도 모르는 static하지 않은 애들에 접근 불가능!)

 */
public class StaticOuterClass {
    private static int outerFiled = 10;

    public void outerMethod(){
        InnerClass inner = new InnerClass();
        inner.innerMethod();

    }

    static class InnerClass{
        public void innerMethod(){
            System.out.println("outerField = " + outerFiled);
        }
    }

    public static void main(String[] args) {
        StaticOuterClass staticOuterClass = new StaticOuterClass();
        staticOuterClass.outerMethod();
    }
}
