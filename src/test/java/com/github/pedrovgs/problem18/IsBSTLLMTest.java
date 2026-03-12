package com.github.pedrovgs.problem18;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * LLM-generated test cases for IsBST.
 */
public class IsBSTLLMTest {

    private final IsBST checker = new IsBST();

    private BinaryNode<Integer> buildValidBST() {
        //       4
        //      / \
        //     2   6
        //    / \ / \
        //   1  3 5  7
        BinaryNode<Integer> root = new BinaryNode<>(4);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n6 = new BinaryNode<>(6);
        BinaryNode<Integer> n1 = new BinaryNode<>(1);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        BinaryNode<Integer> n5 = new BinaryNode<>(5);
        BinaryNode<Integer> n7 = new BinaryNode<>(7);
        root.setLeft(n2); root.setRight(n6);
        n2.setLeft(n1); n2.setRight(n3);
        n6.setLeft(n5); n6.setRight(n7);
        return root;
    }

    private BinaryNode<Integer> buildInvalidBST() {
        //       4
        //      / \
        //     5   3  <- invalid structure
        BinaryNode<Integer> root = new BinaryNode<>(4);
        BinaryNode<Integer> left = new BinaryNode<>(5);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveWithNullInput() {
        checker.checkRecursive(null);
    }

    @Test
    public void testRecursiveSingleNode() {
        BinaryNode<Integer> node = new BinaryNode<>(10);
        assertTrue(checker.checkRecursive(node));
    }

    @Test
    public void testRecursiveValidBST() {
        BinaryNode<Integer> root = buildValidBST();
        assertTrue(checker.checkRecursive(root));
    }

    @Test
    public void testRecursiveInvalidBST() {
        BinaryNode<Integer> root = buildInvalidBST();
        assertFalse(checker.checkRecursive(root));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeWithNullInput() {
        checker.checkIterative(null);
    }

    @Test
    public void testIterativeValidBST() {
        BinaryNode<Integer> root = buildValidBST();
        assertTrue(checker.checkIterative(root));
    }

    @Test
    public void testIterativeInvalidBST() {
        BinaryNode<Integer> root = buildInvalidBST();
        assertFalse(checker.checkIterative(root));
    }

    @Test
    public void testIsListOrderedWithSingleNode() {
        // indirectly tested, but we’ll isolate for coverage
        // Simulating via reflection would be unnecessary; instead, rely on iterative check
        BinaryNode<Integer> root = new BinaryNode<>(5);
        assertTrue(checker.checkIterative(root));
    }
}