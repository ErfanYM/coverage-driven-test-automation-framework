package com.github.pedrovgs.problem43;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * LLM-generated tests to improve coverage for CombinationOfIntegers.
 */
public class CombinationOfIntegersLLMTest {

    private CombinationOfIntegers comb;

    @Before
    public void setUp() {
        comb = new CombinationOfIntegers();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputThrowsException() {
        comb.calculate(null);
    }

    @Test
    public void testEmptySetReturnsSetWithEmptySubset() {
        Set<Integer> input = new HashSet<>();
        Set<Set<Integer>> result = comb.calculate(input);
        assertEquals(1, result.size());
        assertTrue(result.contains(new HashSet<Integer>()));
    }

    @Test
    public void testSingleElementSet() {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        Set<Set<Integer>> result = comb.calculate(input);
        assertEquals(2, result.size());
        assertTrue(result.contains(new HashSet<Integer>())); // ∅
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        assertTrue(result.contains(expected));
    }

    @Test
    public void testTwoElementSetProducesFourCombinations() {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        Set<Set<Integer>> result = comb.calculate(input);
        assertEquals(4, result.size());

        assertTrue(result.contains(new HashSet<Integer>()));       // ∅
        assertTrue(result.contains(new HashSet<Integer>() {{ add(1); }}));
        assertTrue(result.contains(new HashSet<Integer>() {{ add(2); }}));
        assertTrue(result.contains(new HashSet<Integer>() {{ add(1); add(2); }}));
    }

    @Test
    public void testThreeElementSetProducesEightCombinations() {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Set<Set<Integer>> result = comb.calculate(input);
        assertEquals(8, result.size()); // 2^3 = 8
    }

    @Test
    public void testAllReturnedSubsetsAreUnique() {
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Set<Set<Integer>> result = comb.calculate(input);

        Set<String> seen = new HashSet<>();
        for (Set<Integer> subset : result) {
            assertTrue("Duplicate subset detected", seen.add(subset.toString()));
        }
    }
}