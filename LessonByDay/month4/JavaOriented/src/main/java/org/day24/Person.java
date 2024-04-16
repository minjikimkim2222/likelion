package org.day24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    //    @Override
//    public int compareTo(Person p) { // 나이 순서에 따라 정렬
//        if (this.age > p.getAge())
//            return 1;
//        if (this.age < p.getAge())
//            return -1;
//        return 0;
//    }

    @Override
    public int compareTo(Person p) { // 이름 알파벳 순서에 따라 정렬
        return this.name.compareTo(p.getName());
            // 이미! String 클래스에서 comparable 인터페이스를 오버라이드한 compareTo 함수가 있으니, 써먹으면 됨
    }

    @Override
    public String toString() {
        return "name : " + this.name + ", age : " + this.age;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("kang", 30));
        list.add(new Person("kim", 20));
        list.add(new Person("kong", 43));

        System.out.println(list);
        Collections.sort(list); // 이름 기준으로 정렬
        System.out.println(list);

        Collections.sort(list, new Comparator<Person>() { // 이 sort는 나이 기준으로 정렬
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(list);
    }
}


