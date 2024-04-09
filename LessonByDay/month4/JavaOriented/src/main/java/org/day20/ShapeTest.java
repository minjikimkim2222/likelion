package org.day20;

public class ShapeTest {
    public static void main(String[] args) {

        Shape triangle = new Triangle(10,5);
        Shape rectangle = new Rectangle(10,20);
        System.out.println("삼각형의 너비 : " + triangle.calculateArea());
        System.out.println("사각형의 너비 : " + rectangle.calculateArea());
        System.out.println("1 >>> " + triangle.toString());

        Triangle triangle1 = new Triangle(10,3);
        System.out.println("2 >>> " + triangle1.toString());
    }
}
