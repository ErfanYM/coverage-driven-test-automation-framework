package com.github.pedrovgs.problem25;


import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * LLM-generated test cases for Anagrams.
 */

public class AnagramsLLMTest {
    private final Anagrams anagrams = new Anagrams();

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        anagrams.get(null);
    }

    @Test
    public void testEmptyInput() {
        List<String> result = anagrams.get("");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacter() {
        List<String> result = anagrams.get("A");
        assertEquals(1, result.size());
        assertEquals("A", result.get(0));
    }

    @Test
    public void testTwoCharacters() {
        List<String> result = anagrams.get("AB");
        assertEquals(2, result.size());
        assertTrue(result.contains("AB"));
        assertTrue(result.contains("BA"));
    }

    @Test
    public void testThreeCharacters() {
        List<String> result = anagrams.get("CAT");
        assertEquals(6, result.size());
        assertTrue(result.contains("CAT"));
        assertTrue(result.contains("ACT"));
        assertTrue(result.contains("TAC"));
        assertTrue(result.contains("CTA"));
    }

    @Test
    public void testRepeatedCharacters() {
        List<String> result = anagrams.get("AA");
        assertEquals(2, result.size());
        assertTrue(result.contains("AA"));
    }
}
