package com.github.pedrovgs.problem33;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class SimpleRegularExpressionManualTest {
    private SimpleRegularExpression regex;

    @Before
    public void setUp() {
        regex = new SimpleRegularExpression();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPatternNullThrowsException() {
        regex.evaluate("abc", null);  // covers pattern==null branch
    }
    @Test
    public void testPatternWithoutAsteriskSecondChar() {
        assertTrue(regex.evaluate("ab", "ab"));
    }

    @Test
    public void testEmptySourceMatchesAsteriskPattern() {
        // covers source.length()==0 path
        assertTrue(regex.evaluate("", "a*"));
    }

    @Test
    public void testEmptySourceDoesNotMatchSingleLiteral() {
        // covers source.length()<1 returning false
        assertFalse(regex.evaluate("", "a"));
    }
    @Test
    public void testAsteriskPatternFailsImmediately() {
        // pattern 'b*' and source starts with different char
        assertFalse(regex.evaluate("aaa", "b*"));
    }

    @Test
    public void testWhileLoopNoMatchSkipsImmediately() {
        // covers while condition false immediately
        assertFalse(regex.evaluate("abc", "x*"));
    }

    @Test
    public void testEmptyPatternDoesNotMatchNonEmptySource() {
        assertFalse(regex.evaluate("a", ""));
    }
}
