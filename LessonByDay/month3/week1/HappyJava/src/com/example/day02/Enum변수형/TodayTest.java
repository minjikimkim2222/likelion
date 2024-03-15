package com.example.day02.Enum변수형;

public class TodayTest {
    public static void main(String[] args) {
        Today today = new Today();
        today.setDay(Day.THURSDAY);

        System.out.println(today.getDay());
        System.out.println(today.getDay());
    }
}
