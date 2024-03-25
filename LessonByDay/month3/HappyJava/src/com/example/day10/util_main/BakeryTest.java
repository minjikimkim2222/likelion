package com.example.day10.util_main;

import com.example.day10.util.*;

public class BakeryTest {
    public static void main(String[] args) {
        Bakery bakery = new Bakery(10,20);
        BreadLover breadLover = new BreadLover(bakery);

        breadLover.buyBread(5);
        breadLover.buyBeverage(7);
        bakery.printStatus();

        breadLover.buyBread(6);
        breadLover.buyBeverage(13);
        bakery.printStatus();

    }
}
