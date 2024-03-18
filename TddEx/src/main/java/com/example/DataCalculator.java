package com.example;

import java.time.LocalDate;

public class DataCalculator {
    public int caculateAge(LocalDate birthDate, LocalDate currentDate) {
        return currentDate.getYear() - birthDate.getYear();
    }

    public int calculateBetweenDays(LocalDate day1, LocalDate day2) {
        return (int) day1.until(day2).getDays();
    }

    public boolean isItLeapYear(int leapYear) {
        return LocalDate.ofYearDay(leapYear, 1).isLeapYear();
    }
}
