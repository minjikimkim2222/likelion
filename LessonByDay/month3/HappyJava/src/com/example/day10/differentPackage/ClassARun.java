package com.example.day10.differentPackage;

import com.example.day10.ClassA;
import com.example.day10.MathBean;

public class ClassARun extends ClassA {

    public int getNumber(){
        return number;
    }
    public static void main(String[] args) {
        ClassA a = new ClassA();

  //      System.out.println(a.address); // private
  //      System.out.println(a.count); // package
  //      System.out.println(a.number); // protected -> 상속 관계에 있을 때만 쓸 수 있는
        System.out.println(a.name);

        ClassARun aRun = new ClassARun();
        System.out.println(aRun.getNumber());

        com.example.day10.MathBean mathBean = new MathBean();
        System.out.println("mathBean return test : " + mathBean.getOne());
    }
}
