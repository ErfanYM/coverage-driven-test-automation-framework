package com.github.pedrovgs.problem41;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * LLM-generated additional tests for GoThroughMatrixInSpiral
 * to improve statement and branch coverage.
 */
public class GoThroughMatrixInSpiralLLMTest {

    private GoThroughMatrixInSpiral spiral;

    @Before
    public void setUp() {
        spiral = new GoThroughMatrixInSpiral();
    }

    /* === 1×N matrix === */
    @Test
    public void testSingleRowMatrix() {
        int[][] matrix = {
                {1, 2, 3, 4}
        };
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, spiral.go(matrix));
    }

    /* === N×1 matrix === */
    @Test
    public void testSingleColumnMatrix() {
        int[][] matrix = {
                {1},
                {2},
                {3},
                {4}
        };
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, spiral.go(matrix));
    }

    /* === 2×2 matrix === */
    @Test
    public void testTwoByTwoMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        // Spiral: 1, 2, 4, 3
        int[] expected = {1, 2, 4, 3};
        assertArrayEquals(expected, spiral.go(matrix));
    }

    /* === 3×3 matrix === */
    @Test
    public void testThreeByThreeMatrix() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // Spiral: 1, 2, 3, 6, 9, 8, 7, 4, 5
        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        assertArrayEquals(expected, spiral.go(matrix));
    }

    /* === 3×2 matrix === */
    @Test
    public void testThreeByTwoMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        // Spiral: 1, 2, 4, 6, 5, 3
        int[] expected = {1, 2, 4, 6, 5, 3};
        assertArrayEquals(expected, spiral.go(matrix));
    }
}