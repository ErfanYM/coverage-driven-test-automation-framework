package com.github.pedrovgs.linkedlist;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated test cases for ListNode.
 */

public class ListNodeLLMTest {
    @Test
    public void testGetAndSetData() {
        ListNode<String> node = new ListNode<>("A");
        assertEquals("A", node.getData());

        node.setData("B");
        assertEquals("B", node.getData());
    }
    @Test
    public void testGetAndSetNext() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        first.setNext(second);
        assertEquals(second, first.getNext());
    }
    @Test
    public void testEqualsSameReference() {
        ListNode<String> node = new ListNode<>("A");
        assertTrue(node.equals(node));
    }

    @Test
    public void testEqualsWithEqualData() {
        ListNode<String> n1 = new ListNode<>("A");
        ListNode<String> n2 = new ListNode<>("A");
        assertTrue(n1.equals(n2));
    }

    @Test
    public void testEqualsWithDifferentData() {
        ListNode<String> n1 = new ListNode<>("A");
        ListNode<String> n2 = new ListNode<>("B");
        assertFalse(n1.equals(n2));
    }

    @Test
    public void testEqualsWithNull() {
        ListNode<String> node = new ListNode<>("A");
        assertFalse(node.equals(null));
    }

    @Test
    public void testEqualsWithDifferentObjectType() {
        ListNode<String> node = new ListNode<>("A");
        assertFalse(node.equals("A"));
    }

    @Test
    public void testHashCodeConsistency() {
        ListNode<String> node = new ListNode<>("Data");
        int expected = node.getData().hashCode();
        assertEquals(expected, node.hashCode());
    }

    @Test
    public void testToStringNotNull() {
        ListNode<String> node = new ListNode<>("A");
        assertNotNull(node.toString());
        assertTrue(node.toString().contains("A"));
    }
}
