package org.day29;

import java.util.function.BiFunction;
import java.util.function.Function;

class Car {
    String name;
    String speed;

    public Car() {
    }
    public Car(String name) {
        this.name = name;
    }
    public Car(String name, String speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + ", " + speed;
    }
}
public class ConstructTest {
    public static void main(String[] args) {
        Function<String, Car> func = name -> new Car(name);

        Car car1 = func.apply("sonata");
        System.out.println(car1.name);

        Function<String, Car> func2 = Car :: new;
        Car car2 = func2.apply("그랜저");
        System.out.println(car2.name); // 입력값을 1개 받았으니, name으로 추론된 거임

        BiFunction<String, String, Car> func3 = Car :: new;
        Car car3  = func3.apply("bmw", "fast");
        System.out.println(car3); // 입력값을 2개 받았으니, name, String으로 추론된 거임!
    }
}
