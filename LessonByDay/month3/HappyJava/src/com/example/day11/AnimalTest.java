package com.example.day11;

class Animal {
    public void makeSound() {
        System.out.println("??");
    }
}

class Dog extends Animal {
    public void makeSound(){
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    public void makeSound(){
        System.out.println("냥냥");
    }
}


public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animal = new Animal[3];

        animal[0] = new Cat();
        animal[1] = new Dog();
        animal[2] = new Animal();

        for (int i = 0; i < animal.length; i++){
            animal[i].makeSound();
        }
    }
}
