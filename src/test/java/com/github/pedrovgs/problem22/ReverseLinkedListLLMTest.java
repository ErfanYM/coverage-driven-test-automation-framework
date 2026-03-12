package com.github.pedrovgs.problem22;

import com.github.pedrovgs.linkedlist.ListNode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for ReverseLinkedList problem.
 */
public class ReverseLinkedListLLMTest {
    private final ReverseLinkedList reverser = new ReverseLinkedList();

    private ListNode<Integer> buildList(int... values) {
        if (values.length == 0) return null;
        ListNode<Integer> head = new ListNode<>(values[0]);
        ListNode<Integer> current = head;
        for (int i = 1; i < values.length; i++) {
            ListNode<Integer> node = new ListNode<>(values[i]);
            current.setNext(node);
            current = node;
        }
        return head;
    }

    private int[] toArray(ListNode<Integer> head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.getData());
            head = head.getNext();
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testReverseIterativeMultipleNodes() {
        ListNode<Integer> list = buildList(1, 2, 3, 4);
        ListNode<Integer> reversed = reverser.reverseIterative(list);
        assertArrayEquals(new int[]{4, 3, 2, 1}, toArray(reversed));
    }

    @Test
    public void testReverseIterativeSingleNode() {
        ListNode<Integer> list = buildList(10);
        ListNode<Integer> reversed = reverser.reverseIterative(list);
        assertArrayEquals(new int[]{10}, toArray(reversed));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseIterativeNullInput() {
        reverser.reverseIterative(null);
    }

    @Test
    public void testReverseRecursiveMultipleNodes() {
        ListNode<Integer> list = buildList(5, 6, 7);
        ListNode<Integer> reversed = reverser.reverseRecursive(list);
        assertArrayEquals(new int[]{7, 6, 5}, toArray(reversed));
    }

    @Test
    public void testReverseRecursiveSingleNode() {
        ListNode<Integer> list = buildList(100);
        ListNode<Integer> reversed = reverser.reverseRecursive(list);
        assertArrayEquals(new int[]{100}, toArray(reversed));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseRecursiveNullInput() {
        reverser.reverseRecursive(null);
    }
}
