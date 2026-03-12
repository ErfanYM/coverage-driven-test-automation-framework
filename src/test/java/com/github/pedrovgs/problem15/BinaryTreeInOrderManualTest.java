package com.github.pedrovgs.problem15;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Manual tests to cover recursive and iterative in-order traversal.
 */
public class BinaryTreeInOrderManualTest {

    private BinaryTreeInOrder inorder;

    @Before
    public void setUp() {
        inorder = new BinaryTreeInOrder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveNullThrows() {
        inorder.getRecursive(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeNullThrows() {
        inorder.getIterative(null);
    }

    @Test
    public void testSingleNodeTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        List<BinaryNode<Integer>> result = inorder.getRecursive(root);
        assertEquals(1, result.size());
        assertEquals(Integer.valueOf(10), result.get(0).getData());
    }

    @Test
    public void testBalancedTreeRecursiveOrder() {

        BinaryNode<Integer> root = new BinaryNode<>(2);
        root.setLeft(new BinaryNode<>(1));
        root.setRight(new BinaryNode<>(3));

        List<BinaryNode<Integer>> result = inorder.getRecursive(root);

        assertEquals(3, result.size());
        assertEquals(Integer.valueOf(1), result.get(0).getData());
        assertEquals(Integer.valueOf(2), result.get(1).getData());
        assertEquals(Integer.valueOf(3), result.get(2).getData());
    }

    @Test
    public void testIterativeRightSkewedTree() {

        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        root.setRight(n2);
        n2.setRight(n3);

        List<BinaryNode<Integer>> result = inorder.getIterative(root);

        assertEquals(3, result.size());
        assertEquals(Integer.valueOf(1), result.get(0).getData());
        assertEquals(Integer.valueOf(2), result.get(1).getData());
        assertEquals(Integer.valueOf(3), result.get(2).getData());
    }

    @Test
    public void testIterativeLeftSkewedTree() {
        BinaryNode<Integer> root = new BinaryNode<>(3);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n1 = new BinaryNode<>(1);
        root.setLeft(n2);
        n2.setLeft(n1);

        List<BinaryNode<Integer>> result = inorder.getIterative(root);

        assertEquals(3, result.size());
        assertEquals(Integer.valueOf(1), result.get(0).getData());
        assertEquals(Integer.valueOf(2), result.get(1).getData());
        assertEquals(Integer.valueOf(3), result.get(2).getData());
    }
}