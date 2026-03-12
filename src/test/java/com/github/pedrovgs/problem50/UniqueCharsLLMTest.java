package com.github.pedrovgs.problem50;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * LLM-generated tests to improve coverage for UniqueChars.
 */
public class UniqueCharsLLMTest {

    private UniqueChars uniqueChars;

    @Before
    public void setUp() {
        uniqueChars = new UniqueChars();
    }

    /* === Null input === */
    @Test(expected = IllegalArgumentException.class)
    public void testEvaluateShouldThrowOnNull() {
        uniqueChars.evaluate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvaluate2ShouldThrowOnNull() {
        uniqueChars.evaluate2(null);
    }

    /* === Empty string === */
    @Test
    public void testEmptyStringReturnsTrue() {
        assertTrue(uniqueChars.evaluate(""));
        assertTrue(uniqueChars.evaluate2(""));
    }

    /* === Unique chars === */
    @Test
    public void testUniqueCharsReturnTrue() {
        String input = "abc";
        assertTrue(uniqueChars.evaluate(input));
        assertTrue(uniqueChars.evaluate2(input));
    }

    /* === Duplicate chars === */
    @Test
    public void testDuplicateCharsReturnFalse() {
        String input = "abca";
        assertFalse(uniqueChars.evaluate(input));
        assertFalse(uniqueChars.evaluate2(input));
    }

    /* === Case-sensitive check === */
    @Test
    public void testDifferentCasesAreUnique() {
        String input = "Aa";
        assertTrue(uniqueChars.evaluate(input));
        assertTrue(uniqueChars.evaluate2(input));
    }

    /* === Special ASCII chars === */
    @Test
    public void testSpecialCharsUnique() {
        String input = "!@#";
        assertTrue(uniqueChars.evaluate(input));
        assertTrue(uniqueChars.evaluate2(input));
    }

    @Test
    public void testRepeatedSpecialCharsReturnFalse() {
        String input = "!!";
        assertFalse(uniqueChars.evaluate(input));
        assertFalse(uniqueChars.evaluate2(input));
    }
}