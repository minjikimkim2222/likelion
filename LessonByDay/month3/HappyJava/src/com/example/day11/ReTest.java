package com.example.day11;

public class ReTest {
    public static void main(String[] args) {
        // 1. 부모는 자식을 가리킬 수 있다.
        Parent parent = new Child();
        Object obj1 = new Parent();
        Object obj2 = new Child();

        System.out.println(parent.i);

        Child c = (Child)parent;
        System.out.println(c.i);

        if (obj1 instanceof Child){
            Child c2 = (Child)obj1;
            System.out.println("obj1이 Child형으로 형변환했습니다.");
        }else {
            System.out.println("하지만, obj1은 Parent 실체라, Child 실체(인스턴스는 존재하지 않아)," +
                    "형변환에 실패했다!");
        }

        if (obj2 instanceof Child){
            Child c3 = (Child)obj2;
            System.out.println("obj2의 실체는 Child이기에 형변환 성공!");
        }

        if (obj2 instanceof Parent){
            Parent p3 = (Parent) obj2;
            System.out.println("obj2의 실체인 Child 안에 Parent도 존재하기에, 형변환 성공!");
        }

    }
}
