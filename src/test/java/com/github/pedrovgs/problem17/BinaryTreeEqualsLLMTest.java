package com.github.pedrovgs.problem17;
import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for BinaryTreeEquals.
 */
public class BinaryTreeEqualsLLMTest {

    private final BinaryTreeEquals comparator = new BinaryTreeEquals();

    private BinaryNode<Integer> buildSimpleTree() {
        //    1
        //   / \
        //  2   3
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    private BinaryNode<Integer> buildDifferentStructureTree() {
        //   1
        //  /
        // 2
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.setLeft(new BinaryNode<>(2));
        return root;
    }

    private BinaryNode<Integer> buildDifferentValueTree() {
        //    1
        //   / \
        //  9   3
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(9);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    /* === Recursive Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveWithBothNullTreesThrowsException() {
        comparator.areEqualsRecursive(null, null);
    }

    @Test
    public void testRecursiveEqualTrees() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildSimpleTree();
        assertTrue(comparator.areEqualsRecursive(t1, t2));
    }

    @Test
    public void testRecursiveOneTreeNullReturnsFalse() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        assertFalse(comparator.areEqualsRecursive(t1, null));
    }

    @Test
    public void testRecursiveDifferentStructureReturnsFalse() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildDifferentStructureTree();
        assertFalse(comparator.areEqualsRecursive(t1, t2));
    }

    @Test
    public void testRecursiveDifferentValuesReturnsFalse() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildDifferentValueTree();
        assertFalse(comparator.areEqualsRecursive(t1, t2));
    }

    /* === Iterative Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeWithBothNullTreesThrowsException() {
        comparator.areEqualsIterative(null, null);
    }

    @Test
    public void testIterativeEqualTrees() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildSimpleTree();
        assertTrue(comparator.areEqualsIterative(t1, t2));
    }

    @Test
    public void testIterativeDifferentValuesReturnsFalse() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildDifferentValueTree();
        assertFalse(comparator.areEqualsIterative(t1, t2));
    }

    @Test
    public void testIterativeDifferentStructureReturnsFalse() {
        BinaryNode<Integer> t1 = buildSimpleTree();
        BinaryNode<Integer> t2 = buildDifferentStructureTree();
        assertFalse(comparator.areEqualsIterative(t1, t2));
    }
}
