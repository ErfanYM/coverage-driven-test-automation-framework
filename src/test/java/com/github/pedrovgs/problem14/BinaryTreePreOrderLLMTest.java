package com.github.pedrovgs.problem14;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * LLM-generated test cases for BinaryTreePreOrder.
 */
public class BinaryTreePreOrderLLMTest {
    private final BinaryTreePreOrder traversal = new BinaryTreePreOrder();

    private BinaryNode<Integer> buildSampleTree() {
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        BinaryNode<Integer> n4 = new BinaryNode<>(4);
        BinaryNode<Integer> n5 = new BinaryNode<>(5);
        root.setLeft(n2);
        root.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        return root;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveWithNullInput() {
        traversal.getRecursive(null);
    }

    @Test
    public void testRecursiveSingleNode() {
        BinaryNode<Integer> node = new BinaryNode<>(10);
        List<BinaryNode> result = traversal.getRecursive(node);
        assertEquals(1, result.size());
        assertEquals(node, result.get(0));
    }

    @Test
    public void testRecursiveTraversalOrder() {
        BinaryNode<Integer> root = buildSampleTree();
        List<BinaryNode> result = traversal.getRecursive(root);
        int[] expected = {1, 2, 4, 5, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(Integer.valueOf(expected[i]), result.get(i).getData());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeWithNullInput() {
        traversal.getIterative(null);
    }

    @Test
    public void testIterativeSingleNode() {
        BinaryNode<Integer> node = new BinaryNode<>(99);
        List<BinaryNode> result = traversal.getIterative(node);
        assertEquals(1, result.size());
        assertEquals(node, result.get(0));
    }

    @Test
    public void testIterativeTraversalOrder() {
        BinaryNode<Integer> root = buildSampleTree();
        List<BinaryNode> result = traversal.getIterative(root);
        int[] expected = {1, 2, 4, 5, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(Integer.valueOf(expected[i]), result.get(i).getData());
        }
    }

    @Test
    public void testIterativeRightHeavyTree() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        root.setRight(n2);
        n2.setRight(n3);

        List<BinaryNode> result = traversal.getIterative(root);
        int[] expected = {1, 2, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(Integer.valueOf(expected[i]), result.get(i).getData());
        }
    }
}
