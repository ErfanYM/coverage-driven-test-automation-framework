package com.github.pedrovgs.problem19;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for BinaryTreeDepth.
 */
public class BinaryTreeDepthLLMTest {
    private final BinaryTreeDepth depth = new BinaryTreeDepth();

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionWhenRootIsNull() {
        depth.get(null);
    }

    @Test
    public void testDepthOfSingleNodeTreeIsOne() {
        BinaryNode root = new BinaryNode(10);
        int result = depth.get(root);
        assertEquals(1, result);
    }

    @Test
    public void testDepthOfBalancedTree() {
        BinaryNode root = new BinaryNode(1);
        root.setLeft(new BinaryNode(2));
        root.setRight(new BinaryNode(3));
        root.getLeft().setLeft(new BinaryNode(4));
        root.getRight().setRight(new BinaryNode(5));

        int result = depth.get(root);
        assertEquals(3, result);
    }

    @Test
    public void testDepthOfUnbalancedTree() {
        BinaryNode root = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        root.setLeft(node2);
        node2.setLeft(node3);

        int result = depth.get(root);
        assertEquals(3, result);
    }
}
