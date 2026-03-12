package com.github.pedrovgs.binarytree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests to improve coverage for BinaryNode.
 */
public class BinaryNodeLLMTest {

    @Test
    public void testConstructorAndGetData() {
        BinaryNode<Integer> node = new BinaryNode<>(5);
        assertEquals(Integer.valueOf(5), node.getData());
    }

    @Test
    public void testSetAndGetLeftRightNodes() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);

        root.setLeft(left);
        root.setRight(right);

        assertEquals(left, root.getLeft());
        assertEquals(right, root.getRight());
    }

    @Test
    public void testHasLeftAndHasRight() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        assertFalse(root.hasLeft());
        assertFalse(root.hasRight());

        root.setLeft(new BinaryNode<>(5));
        root.setRight(new BinaryNode<>(15));

        assertTrue(root.hasLeft());
        assertTrue(root.hasRight());
    }

    @Test
    public void testEqualsSameInstance() {
        BinaryNode<Integer> node = new BinaryNode<>(7);
        assertTrue(node.equals(node));
    }

    @Test
    public void testEqualsWithEqualStructure() {
        BinaryNode<Integer> a = new BinaryNode<>(1);
        BinaryNode<Integer> b = new BinaryNode<>(1);
        a.setLeft(new BinaryNode<>(2));
        a.setRight(new BinaryNode<>(3));
        b.setLeft(new BinaryNode<>(2));
        b.setRight(new BinaryNode<>(3));

        assertTrue(a.equals(b));
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testEqualsWithDifferentData() {
        BinaryNode<Integer> a = new BinaryNode<>(1);
        BinaryNode<Integer> b = new BinaryNode<>(2);
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsWithDifferentStructure() {
        BinaryNode<Integer> a = new BinaryNode<>(1);
        BinaryNode<Integer> b = new BinaryNode<>(1);
        a.setLeft(new BinaryNode<>(2));
        // b has no left child
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsWithRightDifferent() {
        BinaryNode<Integer> a = new BinaryNode<>(1);
        BinaryNode<Integer> b = new BinaryNode<>(1);
        a.setRight(new BinaryNode<>(3));
        assertFalse(a.equals(b));
    }

    @Test
    public void testEqualsWithDifferentType() {
        BinaryNode<Integer> a = new BinaryNode<>(1);
        assertFalse(a.equals("Not a node"));
    }

    @Test
    public void testHashCodeConsistency() {
        BinaryNode<String> node = new BinaryNode<>("x");
        int initialHash = node.hashCode();
        assertEquals(initialHash, node.hashCode()); // consistent
    }

    @Test
    public void testToStringContainsData() {
        BinaryNode<String> node = new BinaryNode<>("Hello");
        String result = node.toString();
        assertTrue(result.contains("Hello"));
        assertTrue(result.startsWith("BinaryNode"));
    }
}