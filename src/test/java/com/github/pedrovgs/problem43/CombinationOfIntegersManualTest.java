package com.github.pedrovgs.problem43;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class CombinationOfIntegersManualTest {

    private CombinationOfIntegers combination;

    @Before
    public void setUp() {
        combination = new CombinationOfIntegers();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullInput() {
        combination.calculate(null);
    }

    @Test
    public void shouldReturnSetContainingEmptySetForEmptyInput() {
        Set<Integer> input = new HashSet<Integer>();
        Set<Set<Integer>> result = combination.calculate(input);

        assertEquals(1, result.size());
        assertTrue(result.iterator().next().isEmpty());
    }


    @Test
    public void shouldReturnAllCombinationsForSingleElement() {
        Set<Integer> input = new HashSet<Integer>(Arrays.asList(1));

        Set<Set<Integer>> result = combination.calculate(input);

        // Expected: {}, {1}
        assertEquals(2, result.size());
        assertTrue(result.contains(new HashSet<Integer>()));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(1))));
    }

    @Test
    public void shouldReturnAllCombinationsForTwoElements() {
        Set<Integer> input = new HashSet<Integer>(Arrays.asList(1, 2));

        Set<Set<Integer>> result = combination.calculate(input);

        // Expected: {}, {1}, {2}, {1,2}
        assertEquals(4, result.size());
        assertTrue(result.contains(new HashSet<Integer>()));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(1))));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(2))));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(1, 2))));
    }


    @Test
    public void shouldHandleNegativeNumbersCorrectly() {
        Set<Integer> input = new HashSet<Integer>(Arrays.asList(-1, 2));

        Set<Set<Integer>> result = combination.calculate(input);

        // Expected: {}, {-1}, {2}, {-1,2}
        assertEquals(4, result.size());
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(-1))));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(2))));
        assertTrue(result.contains(new HashSet<Integer>(Arrays.asList(-1, 2))));
    }
}