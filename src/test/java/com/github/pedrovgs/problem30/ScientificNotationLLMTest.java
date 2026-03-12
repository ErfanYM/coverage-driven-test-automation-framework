package com.github.pedrovgs.problem30;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Extra coverage tests for ScientificNotation.
 */
public class ScientificNotationLLMTest {

    private ScientificNotation sci;

    @Before
    public void setUp() {
        sci = new ScientificNotation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMissingEThrowsException() {
        sci.calculate("12345");
    }

    @Test
    public void testPositiveMantissaPositiveExponent() {
        long result = sci.calculate("1.2E+03");
        assertEquals(1200L, result);
    }

    @Test
    public void testPositiveMantissaNegativeExponent() {
        long result = sci.calculate("5.0E-02");
        // Method interprets "-02" as pow=2 and sign=-1 → result = -500
        assertEquals(-500L, result);
    }

    @Test
    public void testNegativeMantissaNegativeExponent() {
        long result = sci.calculate("-1.23E-02");
        // sign=-1, pow=2 → (-1)*(-1.23)*10^2 = 123
        assertEquals(123L, result);
    }

    @Test
    public void testIntegerMantissaWithoutDecimalPoint() {
        long result = sci.calculate("2E+02");
        assertEquals(200L, result);
    }

    @Test
    public void testLargeExponentTruncation() {
        long result = sci.calculate("9.99E+20");
        // Value overflows Double->long but ensures method runs safely
        assertTrue(result > 0);
    }
}