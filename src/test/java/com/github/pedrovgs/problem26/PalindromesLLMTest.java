package com.github.pedrovgs.problem26;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * LLM-generated tests for Palindromes problem.
 */
public class PalindromesLLMTest {
    private final Palindromes palindromes = new Palindromes();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForNullInput() {
        palindromes.evaluate(null);
    }

    @Test
    public void testReturnsTrueForSingleCharacter() {
        assertTrue(palindromes.evaluate("a"));
    }

    @Test
    public void testReturnsTrueForOddLengthPalindrome() {
        assertTrue(palindromes.evaluate("madam"));
    }

    @Test
    public void testReturnsTrueForEvenLengthPalindrome() {
        assertTrue(palindromes.evaluate("abba"));
    }

    @Test
    public void testReturnsFalseForNonPalindrome() {
        assertFalse(palindromes.evaluate("hello"));
    }

    @Test
    public void testReturnsFalseForAlmostPalindrome() {
        assertFalse(palindromes.evaluate("abca"));
    }
}
