package org.day21;

public class Person {
    private final int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        Person person = new Person(23, "minjiki2");

        System.out.println(person.getId());
        System.out.println(person.getName());

    }
}