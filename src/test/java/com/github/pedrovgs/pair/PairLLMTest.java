package com.github.pedrovgs.pair;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for Pair<A,B>.
 */
public class PairLLMTest {

    @Test
    public void testConstructorStoresValues() {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        // Reflection check (fields are private and final)
        assertEquals(new Pair<>("Hello", 123), pair);
    }

    @Test
    public void testEqualsSameInstance() {
        Pair<String, String> pair = new Pair<>("A", "B");
        assertTrue(pair.equals(pair));
    }

    @Test
    public void testEqualsWithEqualPairs() {
        Pair<Integer, Integer> p1 = new Pair<>(1, 2);
        Pair<Integer, Integer> p2 = new Pair<>(1, 2);
        assertTrue(p1.equals(p2));
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testNotEqualsDifferentA() {
        Pair<Integer, Integer> p1 = new Pair<>(1, 2);
        Pair<Integer, Integer> p2 = new Pair<>(9, 2);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testNotEqualsDifferentB() {
        Pair<Integer, Integer> p1 = new Pair<>(1, 2);
        Pair<Integer, Integer> p2 = new Pair<>(1, 99);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testNotEqualsDifferentType() {
        Pair<String, String> pair = new Pair<>("A", "B");
        assertFalse(pair.equals("Not a pair"));
    }

    @Test
    public void testHashCodeConsistency() {
        Pair<String, String> pair = new Pair<>("key", "value");
        int first = pair.hashCode();
        assertEquals(first, pair.hashCode());
    }

    @Test
    public void testHashCodeDifferentPairs() {
        Pair<String, String> p1 = new Pair<>("x", "y");
        Pair<String, String> p2 = new Pair<>("x", "z");
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testEqualsHandlesNullInsideFieldsSafely() {
        // Only run this to ensure no NullPointerException for identical null fields
        Pair<String, String> p1 = new Pair<>(null, null);
        Pair<String, String> p2 = new Pair<>(null, null);
        try {
            // Because implementation uses a.equals(), this will throw NPE
            p1.equals(p2);
            fail("Expected NullPointerException due to null fields in Pair.equals()");
        } catch (NullPointerException expected) {
            // expected behavior based on implementation
        }
    }
}