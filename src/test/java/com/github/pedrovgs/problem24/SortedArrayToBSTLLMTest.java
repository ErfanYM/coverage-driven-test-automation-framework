package com.github.pedrovgs.problem24;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated test cases for SortedArrayToBST.
 */
public class SortedArrayToBSTLLMTest {
    private final SortedArrayToBST converter = new SortedArrayToBST();

    @Test(expected = IllegalArgumentException.class)
    public void testTransformWithNullInput() {
        converter.transform(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransformWithEmptyArray() {
        converter.transform(new Integer[]{});
    }

    @Test
    public void testTransformWithSingleElement() {
        Integer[] arr = {5};
        BinaryNode<Integer> root = converter.transform(arr);
        assertNotNull(root);
        assertEquals(Integer.valueOf(5), root.getData());
        assertNull(root.getLeft());
        assertNull(root.getRight());
    }

    @Test
    public void testTransformWithTwoElements() {
        Integer[] arr = {1, 2};
        BinaryNode<Integer> root = converter.transform(arr);
        assertNotNull(root);
        // root can be either 1 or 2 depending on integer division center
        assertTrue(root.getData().equals(1) || root.getData().equals(2));
        assertNotNull(root.getLeft() == null || root.getRight() == null);
    }

    @Test
    public void testTransformWithMultipleElements() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        BinaryNode<Integer> root = converter.transform(arr);
        assertNotNull(root);
        assertEquals(Integer.valueOf(4), root.getData());
        assertNotNull(root.getLeft());
        assertNotNull(root.getRight());

        // Validate BST property
        assertTrue(root.getLeft().getData() < root.getData());
        assertTrue(root.getRight().getData() > root.getData());
    }

    @Test
    public void testTransformWithUnbalancedArray() {
        Integer[] arr = {10, 20, 30, 40};
        BinaryNode<Integer> root = converter.transform(arr);
        assertNotNull(root);
        assertEquals(Integer.valueOf(20), root.getData());
        assertEquals(Integer.valueOf(10), root.getLeft().getData());
        assertEquals(Integer.valueOf(30), root.getRight().getData());
    }
}
