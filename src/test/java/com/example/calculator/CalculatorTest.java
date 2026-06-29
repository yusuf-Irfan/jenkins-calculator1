package com.example.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calc.divide(4, 2));
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
    }
}
