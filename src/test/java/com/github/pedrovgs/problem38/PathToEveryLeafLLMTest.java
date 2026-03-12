package com.github.pedrovgs.problem38;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Extra coverage for PathToEveryLeaf.
 */
public class PathToEveryLeafLLMTest {

    private PathToEveryLeaf pathToEveryLeaf;

    @Before
    public void setUp() {
        pathToEveryLeaf = new PathToEveryLeaf();
    }

    @Test
    public void testLeftSkewedTreeHasSinglePath() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        root.setLeft(n2);
        n2.setLeft(n3);

        List<List<BinaryNode>> paths = pathToEveryLeaf.calculate(root);

        assertEquals(1, paths.size());
        assertPathTo(paths.get(0), root, n2, n3);
    }

    @Test
    public void testRightSkewedTreeHasSinglePath() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        BinaryNode<Integer> n2 = new BinaryNode<>(20);
        BinaryNode<Integer> n3 = new BinaryNode<>(30);
        root.setRight(n2);
        n2.setRight(n3);

        List<List<BinaryNode>> paths = pathToEveryLeaf.calculate(root);

        assertEquals(1, paths.size());
        assertPathTo(paths.get(0), root, n2, n3);
    }

    @Test
    public void testRootWithOneChildOnly() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        root.setLeft(n2);

        List<List<BinaryNode>> paths = pathToEveryLeaf.calculate(root);

        assertEquals(1, paths.size());
        assertPathTo(paths.get(0), root, n2);
    }

    @Test
    public void testInternalNullSubtreeHandledGracefully() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> rightRight = new BinaryNode<>(4);
        root.setLeft(left);
        root.setRight(right);
        // Simulate missing left subtree
        right.setRight(rightRight);

        List<List<BinaryNode>> paths = pathToEveryLeaf.calculate(root);

        // Should produce two valid leaf paths
        assertEquals(2, paths.size());
        assertPathTo(paths.get(0), root, left);
        assertPathTo(paths.get(1), root, right, rightRight);
    }

    private void assertPathTo(List<BinaryNode> actual, BinaryNode... expected) {
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }
}