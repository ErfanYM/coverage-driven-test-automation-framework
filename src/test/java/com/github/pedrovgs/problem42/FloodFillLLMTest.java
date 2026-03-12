package com.github.pedrovgs.problem42;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Extra coverage for FloodFill.
 */
public class FloodFillLLMTest {

    private FloodFill floodFill;

    @Before
    public void setUp() {
        floodFill = new FloodFill();
    }

    @Test
    public void testStartCoordinatesOutOfBoundsShouldDoNothing() {
        int[][] picture = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        floodFill.apply(picture, 0, 2, 10, 10); // completely out of bounds
        assertArrayEquals(expected, picture);
    }

    @Test
    public void testNegativeCoordinatesShouldDoNothing() {
        int[][] picture = {
                {0, 0},
                {0, 0}
        };
        int[][] expected = {
                {0, 0},
                {0, 0}
        };
        floodFill.apply(picture, 0, 1, -1, 0);
        assertArrayEquals(expected, picture);
    }

    @Test
    public void testPaintingWithSameColorShouldNotChangeAnything() {
        int[][] picture = {
                {1, 1},
                {1, 1}
        };
        int[][] expected = {
                {1, 1},
                {1, 1}
        };
        floodFill.apply(picture, 1, 1, 0, 0);
        assertArrayEquals(expected, picture);
    }

    @Test
    public void testBoundaryFillAtEdgePixel() {
        int[][] picture = {
                {0, 0, 1},
                {0, 1, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {2, 2, 1},
                {2, 1, 1},
                {1, 1, 1}
        };
        floodFill.apply(picture, 0, 2, 0, 0);
        assertArrayEquals(expected, picture);
    }

    @Test
    public void testOneByOneMatrix() {
        int[][] picture = {{0}};
        int[][] expected = {{5}};
        floodFill.apply(picture, 0, 5, 0, 0);
        assertArrayEquals(expected, picture);
    }

    @Test
    public void testRaggedArrayShouldNotThrowError() {
        int[][] picture = {
                {0, 0, 0},
                {1}, // ragged row
                {0, 0}
        };
        int[][] expected = {
                {9, 9, 9},
                {1},
                {0, 0}
        };
        floodFill.apply(picture, 0, 9, 0, 0);
        assertArrayEquals(expected, picture);
    }
}