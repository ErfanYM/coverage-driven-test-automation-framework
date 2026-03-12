package com.github.pedrovgs.problem39;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * LLM-generated tests to improve coverage for MultiplyArrayElements.
 */
public class MultiplyArrayElementsLLMTest {

    private MultiplyArrayElements multiplier;

    @Before
    public void setUp() {
        multiplier = new MultiplyArrayElements();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputThrowsException() {
        multiplier.multiply(null);
    }

    @Test
    public void testEmptyArrayReturnsSame() {
        int[] input = {};
        assertArrayEquals(input, multiplier.multiply(input));
    }

    @Test
    public void testSingleElementArray() {
        int[] input = {7};
        int[] expected = {1}; // since product of "rest of elements" = 1
        assertArrayEquals(expected, multiplier.multiply(input));
    }

    @Test
    public void testTwoElementsArray() {
        int[] input = {2, 3};
        int[] expected = {3, 2};
        assertArrayEquals(expected, multiplier.multiply(input));
    }

    @Test
    public void testMultipleElementsArray() {
        int[] input = {1, 2, 3, 4};
        // output[i] = product of all except i → {24/1, 24/2, 24/3, 24/4}
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, multiplier.multiply(input));
    }

    @Test
    public void testArrayContainingZero() {
        int[] input = {1, 2, 0, 4};
        // product excluding each index: {0, 0, 8, 0}
        int[] expected = {0, 0, 8, 0};
        assertArrayEquals(expected, multiplier.multiply(input));
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = {-1, 2, -3};
        // total product = 6, results: {-6, 3, -2}
        int[] expected = {-6, 3, -2};
        assertArrayEquals(expected, multiplier.multiply(input));
    }
}
