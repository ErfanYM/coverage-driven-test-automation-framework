package com.github.pedrovgs.sortingalgorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class SortingAlgorithmLLMTest {
    private final DummySortingAlgorithm algo = new DummySortingAlgorithm();

    @Test
    public void testSwapWorksCorrectly() {
        int[] arr = {1, 2, 3};
        algo.sort(arr);
        // first two swapped only
        assertArrayEquals(new int[]{2, 1, 3}, arr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInputThrowsOnNull() {
        algo.sort(null);
    }

    @Test
    public void testSingleElementArrayNoChange() {
        int[] arr = {5};
        algo.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testEmptyArrayNoError() {
        int[] arr = {};
        algo.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}
