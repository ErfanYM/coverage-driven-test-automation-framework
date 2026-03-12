package com.github.pedrovgs.problem16;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for BinaryTreePostOrder.
 */
public class BinaryTreePostOrderLLMTest {

    private final BinaryTreePostOrder traversal = new BinaryTreePostOrder();

    private BinaryNode<Integer> buildBalancedTree() {
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4  5    6
        BinaryNode<Integer> n1 = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        BinaryNode<Integer> n4 = new BinaryNode<>(4);
        BinaryNode<Integer> n5 = new BinaryNode<>(5);
        BinaryNode<Integer> n6 = new BinaryNode<>(6);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setRight(n6);
        return n1;
    }

    private BinaryNode<Integer> buildLeftHeavyTree() {
        // 1 -> 2 -> 3
        BinaryNode<Integer> n1 = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        n1.setLeft(n2);
        n2.setLeft(n3);
        return n1;
    }

    private BinaryNode<Integer> buildRightHeavyTree() {
        // 1 -> 2 -> 3 (right only)
        BinaryNode<Integer> n1 = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        n1.setRight(n2);
        n2.setRight(n3);
        return n1;
    }

    /* === Recursive Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveNullTreeThrowsException() {
        traversal.getRecursive(null);
    }

    @Test
    public void testRecursiveSingleNode() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        List<BinaryNode> result = traversal.getRecursive(root);
        assertEquals(1, result.size());
        assertEquals(root, result.get(0));
    }

    @Test
    public void testRecursiveBalancedTree() {
        BinaryNode<Integer> root = buildBalancedTree();
        List<BinaryNode> result = traversal.getRecursive(root);
        // Expected post-order: 4, 5, 2, 6, 3, 1
        int[] expected = {4, 5, 2, 6, 3, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals((Integer) expected[i], result.get(i).getData());
        }
    }

    /* === Iterative Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeNullTreeThrowsException() {
        traversal.getIterative(null);
    }

    @Test
    public void testIterativeSingleNode() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        List<BinaryNode> result = traversal.getIterative(root);
        assertEquals(1, result.size());
        assertEquals(root, result.get(0));
    }

    @Test
    public void testIterativeBalancedTree() {
        BinaryNode<Integer> root = buildBalancedTree();
        List<BinaryNode> result = traversal.getIterative(root);
        // Expected post-order: 4, 5, 2, 6, 3, 1
        int[] expected = {4, 5, 2, 6, 3, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals((Integer) expected[i], result.get(i).getData());
        }
    }

    @Test
    public void testIterativeLeftHeavyTree() {
        BinaryNode<Integer> root = buildLeftHeavyTree();
        List<BinaryNode> result = traversal.getIterative(root);
        // Expected: 3, 2, 1
        int[] expected = {3, 2, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals((Integer) expected[i], result.get(i).getData());
        }
    }

    @Test
    public void testIterativeRightHeavyTree() {
        BinaryNode<Integer> root = buildRightHeavyTree();
        List<BinaryNode> result = traversal.getIterative(root);
        // Expected: 3, 2, 1
        int[] expected = {3, 2, 1};
        for (int i = 0; i < expected.length; i++) {
            assertEquals((Integer) expected[i], result.get(i).getData());
        }
    }

    @Test
    public void testIterativeAndRecursiveProduceSameResult() {
        BinaryNode<Integer> root = buildBalancedTree();
        List<BinaryNode> recursive = traversal.getRecursive(root);
        List<BinaryNode> iterative = traversal.getIterative(root);
        assertEquals(recursive.size(), iterative.size());
        for (int i = 0; i < recursive.size(); i++) {
            assertEquals(recursive.get(i).getData(), iterative.get(i).getData());
        }
    }
}
