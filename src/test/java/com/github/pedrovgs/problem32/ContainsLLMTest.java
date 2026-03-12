package com.github.pedrovgs.problem32;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Extended coverage for Contains class.
 */
public class ContainsLLMTest {

    private Contains contains;

    @Before
    public void setUp() {
        contains = new Contains();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstWordThrowsException() {
        contains.evaluate(null, "Pedro");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSecondWordThrowsException() {
        contains.evaluate("Pe", null);
    }

    @Test
    public void testSubstringFoundInside() {
        assertTrue(contains.evaluate("ed", "Pedro"));
    }

    @Test
    public void testSubstringNotFound() {
        assertFalse(contains.evaluate("zz", "Pedro"));
    }

    @Test
    public void testSubstringEqualToWord() {
        assertTrue(contains.evaluate("Pedro", "Pedro"));
    }

    @Test
    public void testSubstringAtEndOfWord() {
        assertTrue(contains.evaluate("ro", "Pedro"));
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testEmptySubstringThrowsException() {
        contains.evaluate("", "Pedro");
    }

    @Test
    public void testEmptyMainStringReturnsFalse() {
        assertFalse(contains.evaluate("Pe", ""));
    }

    @Test
    public void testSingleCharacterMatch() {
        assertTrue(contains.evaluate("P", "Pedro"));
    }

    @Test
    public void testSingleCharacterNoMatch() {
        assertFalse(contains.evaluate("z", "Pedro"));
    }
}