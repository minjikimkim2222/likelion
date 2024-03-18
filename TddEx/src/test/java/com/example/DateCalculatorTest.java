package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateCalculatorTest {
    private DataCalculator dateCalculator;

    @BeforeEach
    void setUp(){
        dateCalculator = new DataCalculator();
    }

    // 주어진 생년월일, 날짜를 비교해 현재 나이 계산하기
    @Test
    void calculateAge(){
        LocalDate birthDate = LocalDate.of(2002, 9, 29);
        LocalDate currentDate = LocalDate.of(2024, 3, 18);

        Assertions.assertEquals(22, dateCalculator.caculateAge(birthDate, currentDate));
    }

    // 두 날짜 사이의 일수를 계산
    @Test
    void calculateDaysBetween(){
        LocalDate day1 = LocalDate.of(2024, 2, 15);
        LocalDate day2 = LocalDate.of(2024, 3, 1);

        Assertions.assertEquals(15, dateCalculator.calculateBetweenDays(day1, day2));
    }

    // 윤년 계산기
    @Test
    void isLeapYear(){
        int leapYear = 2024;
        boolean isLeap = dateCalculator.isItLeapYear(leapYear);

        Assertions.assertEquals(true, isLeap);
    }
}
