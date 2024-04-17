package org.day25;

import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ObjectStreamExam {
    public static void main(String[] args) {
        Person person = new Person("minjiki2", 23);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"));

            // 객체를 파일에 write
            out.writeObject(person);

            // 파일에서 객체 읽어오기 test!
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"));

            System.out.println(in.readObject().toString());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
