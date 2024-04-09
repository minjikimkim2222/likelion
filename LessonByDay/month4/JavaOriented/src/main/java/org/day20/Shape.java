package org.day20;

abstract public class Shape {
    abstract public double calculateArea();
}

class Triangle extends Shape{
    private int x;
    private int y;
    // 생성자
    public Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public  double calculateArea() {
        return (double)(0.5 * x * y); // 삼각형 넓이 공식
    }
}

class Rectangle extends Shape {

    private int x;
    private int y;
    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public double calculateArea() {
        return (double) x * y; // 직사각형 넓이공식
    }
}
