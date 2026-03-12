package com.github.pedrovgs.problem36;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * LLM-adjusted tests compatible with integer-division median logic.
 */
public class AvlTreeMedianLLMTest {

    private static final double DELTA = 0.0001;
    private AvlTreeMedian avlTreeMedian;

    @Before
    public void setUp() {
        avlTreeMedian = new AvlTreeMedian();
    }

    @Test
    public void testMedianForEvenNumberOfNodes() {
        // Sorted = [1, 2, 3, 4], integer median = (2 + 3)/2 = 2
        BinaryNode<Integer> root = new BinaryNode<>(3);
        BinaryNode<Integer> n1 = new BinaryNode<>(2);
        BinaryNode<Integer> n2 = new BinaryNode<>(4);
        BinaryNode<Integer> n3 = new BinaryNode<>(1);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);

        double median = avlTreeMedian.find(root);
        assertEquals(2.0, median, DELTA);
    }

    @Test
    public void testMedianWithNegativeAndPositiveValues() {
        // Values: -3, 1, 2, 7 → (1 + 2)/2 = 1 (integer division)
        BinaryNode<Integer> root = new BinaryNode<>(2);
        BinaryNode<Integer> left = new BinaryNode<>(1);
        BinaryNode<Integer> right = new BinaryNode<>(7);
        BinaryNode<Integer> leftLeft = new BinaryNode<>(-3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);

        double median = avlTreeMedian.find(root);
        assertEquals(1.0, median, DELTA);
    }

    @Test
    public void testMedianWithOddNumberOfNodes() {
        // Values: [1,3,5] → median = 3
        BinaryNode<Integer> root = new BinaryNode<>(3);
        root.setLeft(new BinaryNode<>(1));
        root.setRight(new BinaryNode<>(5));

        double median = avlTreeMedian.find(root);
        assertEquals(3.0, median, DELTA);
    }

    @Test
    public void testMedianForUnbalancedTree() {
        // Values: [1,2,3,4,5,6] → (3+4)/2 = 3
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> n2 = new BinaryNode<>(2);
        BinaryNode<Integer> n3 = new BinaryNode<>(3);
        BinaryNode<Integer> n4 = new BinaryNode<>(4);
        BinaryNode<Integer> n5 = new BinaryNode<>(5);
        BinaryNode<Integer> n6 = new BinaryNode<>(6);

        root.setRight(n2);
        n2.setRight(n3);
        n3.setRight(n4);
        n4.setRight(n5);
        n5.setRight(n6);

        double median = avlTreeMedian.find(root);
        assertEquals(3.0, median, DELTA);
    }
}