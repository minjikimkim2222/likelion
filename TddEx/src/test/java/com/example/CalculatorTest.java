package com.example;
// static import
import static org.junit.jupiter.api.Assertions.*;
//
import org.junit.jupiter.api.*;

public class CalculatorTest {
    Calculator cal = new Calculator();
    @Test
    void plus(){
        System.out.println("plus 메서드 테스트 실행");
        assertEquals(5, cal.plus(2,3));
    }

    @Test
    void minus(){
        System.out.println("minus 메서드 테스트 실행");
        assertEquals( 2, cal.minus(6,4));
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("테스트 클래스가 실행될 때, 처음에 '한번' 실행됨");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("테스트 메서드가 실행되기 전에 실행, 모든 테스트 메서드마다 실행!");
    }

    @AfterEach
    void afterEach(){
        System.out.println("각각의 테스트 메서드가 실행된 후, 실행!");
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("모든 테스트가 종료된 후, 실행");
    }
}
