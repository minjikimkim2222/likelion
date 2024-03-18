package com.example;
// static import
import static org.junit.jupiter.api.Assertions.*;
//
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator cal = new Calculator();
    @Test
    void plus(){
        assertEquals(5, cal.plus(2,3));
    }

    @Test
    void minus(){
        assertEquals( 2, cal.minus(6,4));
    }
}
