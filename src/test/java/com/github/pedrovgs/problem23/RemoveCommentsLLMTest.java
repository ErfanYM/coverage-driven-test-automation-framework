package com.github.pedrovgs.problem23;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for RemoveComments and FakeFile.
 */
public class RemoveCommentsLLMTest {

    private final RemoveComments remover = new RemoveComments();

    @Test(expected = IllegalArgumentException.class)
    public void testNullFileThrowsException() {
        remover.remove(null);
    }

    @Test
    public void testNoComments() {
        FakeFile file = new FakeFile("int a = 5;", "return a;");
        String result = remover.remove(file);
        assertEquals("int a = 5;return a;", result);
    }

    @Test
    public void testSingleLineComment() {
        FakeFile file = new FakeFile("int a = 5; /* comment */ int b = 6;");
        String result = remover.remove(file);
        assertTrue(result.contains("int a = 5;"));
        assertTrue(result.contains("int b = 6;"));
        assertFalse(result.contains("comment"));
    }

    @Test
    public void testMultiLineBlockComment() {
        FakeFile file = new FakeFile(
                "code1 /* start",
                "middle *",
                "end */ code2"
        );
        String result = remover.remove(file);
        assertTrue(result.contains("code1"));
        assertTrue(result.contains("code2"));
        assertFalse(result.contains("start"));
    }

    @Test
    public void testInlineCommentAtEnd() {
        FakeFile file = new FakeFile("System.out.println(a); /* ignore */");
        String result = remover.remove(file);
        assertEquals("System.out.println(a);", result.trim());
    }

    @Test
    public void testMultipleLinesNoComments() {
        FakeFile file = new FakeFile(
                "line1",
                "line2",
                "line3"
        );
        String result = remover.remove(file);
        assertEquals("line1line2line3", result);
    }

    @Test
    public void testCommentSpanningTwoLinesWithCodeAfter() {
        FakeFile file = new FakeFile(
                "int x = 0; /* comment",
                "still comment */ x++;"
        );
        String result = remover.remove(file);
        assertTrue(result.contains("int x = 0;"));
        assertTrue(result.contains("x++;"));
        assertFalse(result.contains("comment"));
    }

    @Test
    public void testFakeFileGetLineExhaustion() {
        FakeFile file = new FakeFile("a", "b");
        assertEquals("a", file.getLine());
        assertEquals("b", file.getLine());
        assertNull(file.getLine()); // should return null after last line
    }
}
