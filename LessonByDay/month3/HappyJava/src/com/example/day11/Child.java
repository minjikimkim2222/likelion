package com.example.day11;

import java.util.Objects;

public class Child extends Parent{

    int i = 10;
    public int getI(){ // 오버라이딩
        return i;
    }
    int getI(int i){ // 오버로딩
        return i;
    }

}
