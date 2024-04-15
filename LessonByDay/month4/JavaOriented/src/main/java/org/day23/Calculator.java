package org.day23;

public class Calculator<T extends Number>{
    private T number;

    public Calculator(T number){
        this.number = number;
    }

    public int squareInt(){
        return number.intValue() * number.intValue();
    }

    public double squareDouble(){
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        Calculator<Integer> number1 = new Calculator<>(12);
        Calculator<Double> number2 = new Calculator<>(4.4);

        System.out.println(number1.squareInt());
        System.out.println(number2.squareDouble());
    }
}
