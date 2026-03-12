package com.github.pedrovgs.problem1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * LLM-generated extended tests for BitsCounter to reach 100 % coverage.
 */
public class BitsCounterLLMTest {

    private BitsCounter bitsCounter;

    @Before
    public void setUp() {
        bitsCounter = new BitsCounter();
    }

    // ---------- countBitsToOneBasedOnString ----------

    @Test
    public void testCountBitsToOneBasedOnStringZero() {
        assertEquals(0, bitsCounter.countBitsToOneBasedOnString(0));
    }

    @Test
    public void testCountBitsToOneBasedOnStringMultipleBits() {
        // 7 = 111 → 3 bits set
        assertEquals(3, bitsCounter.countBitsToOneBasedOnString(7));
        // 8 = 1000 → 1 bit set
        assertEquals(1, bitsCounter.countBitsToOneBasedOnString(8));
    }

    @Test
    public void testCountBitsToOneBasedOnStringLargeNumber() {
        // Integer.MAX_VALUE has 31 bits set
        assertEquals(31, bitsCounter.countBitsToOneBasedOnString(Integer.MAX_VALUE));
    }

    // ---------- countBitsToOneBasedOnBinaryOperators ----------

    @Test
    public void testCountBitsToOneBasedOnBinaryOperatorsZero() {
        assertEquals(0, bitsCounter.countBitsToOneBasedOnBinaryOperators(0));
    }

    @Test
    public void testCountBitsToOneBasedOnBinaryOperatorsPowerOfTwo() {
        // 8 = 1000 → 1 bit set
        assertEquals(1, bitsCounter.countBitsToOneBasedOnBinaryOperators(8));
    }

    @Test
    public void testCountBitsToOneBasedOnBinaryOperatorsLargeValue() {
        // Integer.MAX_VALUE → 31 bits set
        assertEquals(31, bitsCounter.countBitsToOneBasedOnBinaryOperators(Integer.MAX_VALUE));
    }

    // ---------- countNumberOfBitsLogN ----------

    @Test
    public void testCountNumberOfBitsLogNZero() {
        assertEquals(0, BitsCounter.countNumberOfBitsLogN(0));
    }

    @Test
    public void testCountNumberOfBitsLogNPositive() {
        // 7 = 111 → 3 bits set
        assertEquals(3, BitsCounter.countNumberOfBitsLogN(7));
        // 8 = 1000 → 1 bit set
        assertEquals(1, BitsCounter.countNumberOfBitsLogN(8));
    }

    @Test
    public void testCountNumberOfBitsLogNNegativeOne() {
        // -1 → all 32 bits set
        assertEquals(32, BitsCounter.countNumberOfBitsLogN(-1));
    }
}