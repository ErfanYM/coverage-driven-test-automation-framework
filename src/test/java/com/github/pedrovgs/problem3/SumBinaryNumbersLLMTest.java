package com.github.pedrovgs.problem3;

import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

/**
 * Extra coverage tests for SumBinaryNumbers.
 */
public class SumBinaryNumbersLLMTest {

    private SumBinaryNumbers sum;

    @Before
    public void setUp() {
        sum = new SumBinaryNumbers();
    }

    // --- validateInput edge cases ---

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInputThrowsWhenOnlyOneIsNull() {
        sum.sumBinaryNumbersCheating("1", null);
    }

    // --- getValueAt reflection test ---

    @Test(expected = IllegalArgumentException.class)
    public void testGetValueAtThrowsForInvalidChar() throws Exception {
        Method m = SumBinaryNumbers.class.getDeclaredMethod("getValueAt", String.class, int.class);
        m.setAccessible(true);
        try {
            m.invoke(null, "2", 0);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw (IllegalArgumentException) e.getTargetException();
        }
    }

    // --- unequal length cases ---

    @Test
    public void testUnequalLengthBasedOnCount() {
        String result = sum.sumBinaryNumbersBasedOnCount("101", "1");
        assertEquals("110", result);  // 5 + 1 = 6
    }

    @Test
    public void testUnequalLengthBasedOnPowersOfTwoHandledByPadding() {
        // Pad shorter binary manually because method expects same length
        String result = sum.sumBinaryNumbersBasedOnPowersOfTwo("101", "001");
        assertEquals("110", result);
    }


    // --- leading zeros ---

    @Test
    public void testLeadingZerosAreHandled() {
        String result = sum.sumBinaryNumbersBasedOnCount("0001", "1");
        // Normalize numeric values for fair comparison
        int expected = Integer.parseInt("10", 2);
        int actual = Integer.parseInt(result, 2);
        assertEquals(expected, actual);
    }

    // --- carry at the end (short binary) ---

    @Test
    public void testCarryAppendedAtEnd() {
        String result = sum.sumBinaryNumbersBasedOnCount("1", "1");
        assertEquals("10", result);
    }

    // --- zero with longer binary ---

    @Test
    public void testZeroPlusLongBinary() {
        String result = sum.sumBinaryNumbersCheating("0", "1111");
        assertEquals("1111", result);
    }
}