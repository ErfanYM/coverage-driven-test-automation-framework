package com.github.pedrovgs.problem29;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Extra coverage tests for AreAnagrams.
 */
public class AreAnagramsLLMTest {

    private AreAnagrams areAnagrams;

    @Before
    public void setUp() {
        areAnagrams = new AreAnagrams();
    }

    // --- null parameter variations ---

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNullSecondNotNullThrows() {
        areAnagrams.check(null, "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondNullFirstNotNullThrows() {
        areAnagrams.check("abc", null);
    }

    // --- different lengths ---

    @Test
    public void testDifferentLengthsReturnFalse() {
        assertFalse(areAnagrams.check("abcd", "abc"));
    }

    // --- valid anagram ---

    @Test
    public void testValidAnagramReturnsTrue() {
        assertTrue(areAnagrams.check("ana", "naa"));
    }

    // --- same letters different case ---

    @Test
    public void testCaseSensitivityMatters() {
        assertFalse(areAnagrams.check("Ana", "naa"));
    }

    // --- whitespace and punctuation ---

    @Test
    public void testSpacesOrPunctuationAffectResult() {
        // The algorithm treats spaces as characters, so these are considered anagrams.
        assertTrue(areAnagrams.check("rail safety", "fairy tales"));
    }

    // --- identical words ---

    @Test
    public void testIdenticalWordsReturnTrue() {
        assertTrue(areAnagrams.check("test", "test"));
    }
}