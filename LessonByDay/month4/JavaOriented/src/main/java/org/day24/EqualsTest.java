package org.day24;

import java.util.Objects;

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void printHashCode(Object object){
        System.out.println(object.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person2 person2)) return false;
        return Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
public class EqualsTest {
    public static void main(String[] args) {
        Person2 p1 = new Person2("minjiki2", 23);
        Person2 p2 = new Person2("minjiki2", 23);
        Person2 p3 = p2;

        if (p1.equals(p2)){
            System.out.println("p1과 p2는 서로 같습니다.");
        } else
            System.out.println("p1과 p2는 서로 다릅니다.");

        if (p3.equals(p2))
            System.out.println("p2와 p3는 서로 같습니다.");
        else
            System.out.println("p2와 p3는 서로 다릅니다.");

        Person2.printHashCode(p1);
        Person2.printHashCode(p2);
        Person2.printHashCode(p3);
    }
}
