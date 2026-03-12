package com.github.pedrovgs.problem20;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for MultiplicationWithoutMultiply.
 */
public class MultiplicationWithoutMultiplyLLMTest {
    private final MultiplicationWithoutMultiply multiplier = new MultiplicationWithoutMultiply();

    @Test
    public void testPositiveTimesPositive() {
        assertEquals(12, multiplier.calculate(3, 4));
    }

    @Test
    public void testPositiveTimesNegative() {
        assertEquals(-12, multiplier.calculate(3, -4));
    }

    @Test
    public void testNegativeTimesPositive() {
        assertEquals(-12, multiplier.calculate(-3, 4));
    }

    @Test
    public void testNegativeTimesNegative() {
        assertEquals(12, multiplier.calculate(-3, -4));
    }

    @Test
    public void testTimesZero() {
        assertEquals(0, multiplier.calculate(5, 0));
    }

    @Test
    public void testZeroTimesAny() {
        assertEquals(0, multiplier.calculate(0, 5));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(100, multiplier.calculate(10, 10));
    }
}
