package com.github.pedrovgs.problem46;


import com.github.pedrovgs.binarytree.BinaryNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeSerializationManualTest {
    private BinaryTreeSerialization serializer;

    @Before
    public void setUp() {
        serializer = new BinaryTreeSerialization();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeserializeNullThrowsException() {
        // Covers: validateInput(tree == null)
        serializer.deserialize(null);
    }

    @Test
    public void testDeserializeEmptyStringReturnsNull() {
        // Covers: if (index >= tree.length()) return null;
        BinaryNode<Integer> result = serializer.deserialize("");
        assertNull(result);
    }

    @Test
    public void testSerializeSingleNodeTree() {
        // Covers serializeInner() with root != null and left/right == null
        BinaryNode<Integer> root = new BinaryNode<>(5);
        String serialized = serializer.serialize(root);
        assertEquals("5##", serialized); // pre-order: root + left(null) + right(null)
    }

    @Test
    public void testDeserializeSingleNodeTree() {
        // Covers deserialization where root != '#' and left/right are null
        String serialized = "5##";
        BinaryNode<Integer> node = serializer.deserialize(serialized);
        assertNotNull(node);
        assertEquals(Integer.valueOf(5), node.getData());
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }
}
