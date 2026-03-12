package com.github.pedrovgs.problem5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Extra coverage tests for DivideUsingSubtraction.
 */
public class DivideUsingSubtractionLLMTest {

    private static final double DELTA = 0.1;
    private DivideUsingSubtraction divider;

    @Before
    public void setUp() {
        divider = new DivideUsingSubtraction();
    }

    // --- Iterative edge cases ---

    @Test
    public void testDividendEqualsDividerIterative() {
        float result = divider.divideIterative(5, 5);
        assertEquals(1.0f, result, DELTA);
    }

    @Test
    public void testDividendLessThanDividerIterative() {
        float result = divider.divideIterative(3, 5);
        assertEquals(0.6f, result, DELTA);
    }

    @Test
    public void testFractionalResultIterative() {
        float result = divider.divideIterative(5, 2);
        assertEquals(2.5f, result, DELTA);
    }

    @Test
    public void testNegativeDividendIterative() {
        float result = divider.divideIterative(-10, 2);
        assertTrue(result <= 0);
    }

    // --- Recursive edge cases ---

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroRecursiveThrows() {
        divider.divideRecursive(10, 0);
    }

    @Test
    public void testDividendZeroRecursive() {
        float result = divider.divideRecursive(0, 5);
        assertEquals(0f, result, DELTA);
    }

    @Test
    public void testDividendLessThanDividerRecursive() {
        float result = divider.divideRecursive(3, 5);
        assertEquals(0.6f, result, DELTA);
    }

    @Test
    public void testFractionalResultRecursive() {
        float result = divider.divideRecursive(5, 2);
        assertEquals(2.5f, result, DELTA);
    }

    @Test
    public void testNegativeDividendRecursive() {
        float result = divider.divideRecursive(-10, 2);
        assertTrue(result <= 0);
    }
}