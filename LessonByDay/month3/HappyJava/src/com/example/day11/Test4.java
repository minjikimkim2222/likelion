package com.example.day11;

public class Test4 {
    public static void main(String[] args) {
        Parent p = new Child();

        System.out.println(p.i);
        System.out.println(p.toString());

        Child c = (Child)p;

        System.out.println(c.i);

        Object obj = new Child(); // 타입은 Object, 실체는 Child
        // 타입이 Object이기에, obj는 Object에 정의된 내용에만 접근 가능
        System.out.println(obj.toString());
        // 하지만 실체는 Child이기에 Child 클래스에 정의된 멤버변수, 멤버함수 접근 원하면
        // 형변환 해야 함
        Child c2 = (Child)obj;
        System.out.println(c2.getI()); // 오버라이딩된 메서드는, 자식 클래스를 따른다!

        // instanceof 예제 체킹
        Object obj3 = new Parent();

        if (obj3 instanceof Child) {
            Child ch = (Child) obj3;
            System.out.println("위 조건을 만족해야 형변환됨. 아니면 실체가 안 맞기에 형변환 예외");
        }

        if (obj3 instanceof Parent){
            Parent testP = (Parent)obj3;
            System.out.println("실체가, 인스턴스가 맞아떨어지기에 형변환 성공!");
        }




    }
}
