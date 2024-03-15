package com.example.day02.연산자;

public class OperationEx2 {
    public static void main(String[] args){
        // 산술연산자
        int a = 4 / 3;
        int e = 4 % 3;
        System.out.println("a : " + a);
        System.out.println("e : " + e);

        // 증감연산자
        int a2 = 5;
        ++a2;

        System.out.println("a2 : " + a2++);
        System.out.println("a2 : " + a2);

        // Wrapper클래스 - 정수와 실수의 최대/최소
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;

        System.out.println("maxInt : " + maxInt);
        System.out.println("minInt : " + minInt);

        System.out.println("minDouble : " + minDouble);
        System.out.println("maxDouble : " + maxDouble);

        // private 변수 접근 - 다른 클래스의 private 멤버변수 접근
//        com.example.day02.기타_예제.Book book = new com.example.day02.기타_예제.Book();
//        int price = book.getPrice();

        // static - static이 붙은 필드(멤버변수)는 그 값을 인스턴스화한다.
        int price = Book.price;

        System.out.println("price : " + price);

        Book.setPrice(100);
        System.out.println(Book.getPrice());

        // final 키워드
            // final 변수 - 그 변수는 더이상 변할 수 없음; 변수의 상수화
            // final 메서드 - 그 메서드는 더이상 변할 수 없음; 함수의 상수화
            //  -> final이 붙은 메서드에 extends를 붙여, 해당 함수를 오버라이딩할 수 없게끔!
    }
}
