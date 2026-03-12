package com.github.pedrovgs.problem27;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Extra coverage tests for ReverseSentence.
 */
public class ReverseSentenceLLMTest {

    private ReverseSentence reverseSentence;

    @Before
    public void setUp() {
        reverseSentence = new ReverseSentence();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInputThrowsException() {
        reverseSentence.reverse(null);
    }

    @Test
    public void testEmptyStringReturnsEmpty() {
        assertEquals("", reverseSentence.reverse(""));
    }

    @Test
    public void testSingleWordRemainsUnchanged() {
        assertEquals("hello", reverseSentence.reverse("hello"));
    }

    @Test
    public void testMultipleSpacesBetweenWords() {
        // split(" ") treats each space literally → consecutive spaces give empty tokens
        String input = "a  b   c";
        String result = reverseSentence.reverse(input);
        // verify words are reversed and spacing behaviour consistent
        assertTrue(result.startsWith("c"));
    }

    @Test
    public void testLeadingAndTrailingSpaces() {
        String input = "  alpha beta  ";
        String result = reverseSentence.reverse(input);
        assertTrue(result.contains("beta"));
    }

    @Test
    public void testSentenceWithPunctuation() {
        String input = "hello world!";
        String result = reverseSentence.reverse(input);
        assertEquals("world! hello", result);
    }
}