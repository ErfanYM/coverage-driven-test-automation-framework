package com.github.pedrovgs.problem14;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinaryTreePreOrderManualTest {

    private BinaryTreePreOrder traversal;

    @Before
    public void setUp() {
        traversal = new BinaryTreePreOrder();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRootIsNull() {
        traversal.getRecursive(null);
    }


    @Test
    public void shouldReturnSingleNodeForSingleElementTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);

        List<BinaryNode> result = traversal.getRecursive(root);

        assertEquals(Arrays.asList(root), result);
    }

    @Test
    public void shouldTraverseLeftOnlyTree() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        root.setLeft(left);

        List<BinaryNode> result = traversal.getIterative(root);

        assertEquals(Arrays.asList(root, left), result);
    }

    @Test
    public void shouldTraverseRightOnlyTree() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> right = new BinaryNode<>(2);
        root.setRight(right);

        List<BinaryNode> result = traversal.getRecursive(root);

        assertEquals(Arrays.asList(root, right), result);
    }


    @Test
    public void shouldReturnCorrectPreOrderForBalancedTree() {
        // Tree: 1 → (2, 3)
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        root.setLeft(left);
        root.setRight(right);

        List<BinaryNode> recursive = traversal.getRecursive(root);
        List<BinaryNode> iterative = traversal.getIterative(root);
        List<BinaryNode> expected = Arrays.asList(root, left, right);

        assertEquals(expected, recursive);
        assertEquals(expected, iterative);
    }
}