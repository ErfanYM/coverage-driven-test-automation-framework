package com.github.pedrovgs.problem21;

import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * LLM-generated tests for LowestCommonAncestor.
 */
public class LowestCommonAncestorLLMTest {

    private final LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

    private BinaryNode<Integer> buildTree() {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
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

    private BinaryNode<Integer>[] getNodes(BinaryNode<Integer> root) {
        // Utility to fetch references manually
        BinaryNode<Integer> n1 = root;
        BinaryNode<Integer> n2 = root.getLeft();
        BinaryNode<Integer> n3 = root.getRight();
        BinaryNode<Integer> n4 = n2.getLeft();
        BinaryNode<Integer> n5 = n2.getRight();
        BinaryNode<Integer> n6 = n3.getRight();
        return new BinaryNode[]{n1, n2, n3, n4, n5, n6};
    }

    /* === Recursive Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testRecursiveWithNullInputsThrowsException() {
        lcaFinder.getRecursive(null, null, null);
    }

    @Test
    public void testRecursiveLCAOfTwoDeepNodes() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getRecursive(root, nodes[3], nodes[4]); // nodes 4 & 5
        assertEquals(nodes[1], result); // Expected LCA is node 2
    }

    @Test
    public void testRecursiveLCAWithRootAsAncestor() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getRecursive(root, nodes[4], nodes[5]); // 5 & 6
        assertEquals(nodes[0], result); // Expected LCA is root (1)
    }

    @Test
    public void testRecursiveLCAWhenOneNodeIsAncestorOfTheOther() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getRecursive(root, nodes[1], nodes[4]); // 2 & 4
        assertEquals(nodes[1], result); // Node 2 is ancestor
    }

    /* === Iterative Tests === */

    @Test(expected = IllegalArgumentException.class)
    public void testIterativeWithNullInputsThrowsException() {
        lcaFinder.getIterative(null, null, null);
    }

    @Test
    public void testIterativeLCAOfTwoDeepNodes() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getIterative(root, nodes[3], nodes[4]); // 4 & 5
        assertNotNull(result);
    }

    @Test
    public void testIterativeLCAWithRootAsAncestor() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getIterative(root, nodes[4], nodes[5]); // 5 & 6
        assertNotNull(result);
    }

    @Test
    public void testIterativeLCAWhenOneNodeIsAncestorOfTheOther() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> result = lcaFinder.getIterative(root, nodes[1], nodes[4]); // 2 & 4
        assertNotNull(result);
    }

    @Test
    public void testIterativeWithDisjointSubtreesReturnsNull() {
        // Artificially create two separate trees
        BinaryNode<Integer> tree1 = new BinaryNode<>(1);
        BinaryNode<Integer> tree2 = new BinaryNode<>(2);
        BinaryNode<Integer> nodeA = new BinaryNode<>(3);
        BinaryNode<Integer> nodeB = new BinaryNode<>(4);
        tree1.setLeft(nodeA);
        tree2.setRight(nodeB);

        BinaryNode<Integer> result = lcaFinder.getIterative(tree1, nodeA, nodeB);
        // Expected null since nodeB isn’t in tree1
        assertNull(result);
    }

    /* === Consistency Test === */

    @Test
    public void testRecursiveAndIterativeProduceCompatibleResults() {
        BinaryNode<Integer> root = buildTree();
        BinaryNode<Integer>[] nodes = getNodes(root);
        BinaryNode<Integer> recursive = lcaFinder.getRecursive(root, nodes[4], nodes[5]);
        BinaryNode<Integer> iterative = lcaFinder.getIterative(root, nodes[4], nodes[5]);
        assertNotNull(recursive);
        assertNotNull(iterative);
    }
}