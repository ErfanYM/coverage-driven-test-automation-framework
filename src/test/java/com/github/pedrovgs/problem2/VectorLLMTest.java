package com.github.pedrovgs.problem2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Extra coverage tests for Vector and VectorScalarProduct.
 */
public class VectorLLMTest {

    @Test
    public void testConstructorAndBasicAccessors() {
        Vector v = new Vector(10, 20, 30);
        assertEquals(3, v.size());
        assertEquals(10, v.getAt(0));
        assertEquals(30, v.getAt(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorRejectsNullArray() {
        new Vector((int[]) null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetAtOutOfRangeThrowsException() {
        Vector v = new Vector(1, 2, 3);
        v.getAt(10);
    }

    @Test
    public void testToStringShowsBracketedElements() {
        Vector v = new Vector(1, 2, 3);
        String s = v.toString();
        assertTrue(s.startsWith("["));
        assertTrue(s.endsWith("]"));
        assertTrue(s.contains("1"));
    }

    @Test
    public void testScalarProductSingleElementVector() {
        VectorScalarProduct sp = new VectorScalarProduct();
        Vector v1 = new Vector(5);
        Vector v2 = new Vector(5);
        int result = sp.calculateScalarProduct(v1, v2);
        assertEquals(25, result);
    }

    @Test
    public void testScalarProductWithMixedSigns() {
        VectorScalarProduct sp = new VectorScalarProduct();
        Vector v1 = new Vector(-2, 3, -4);
        Vector v2 = new Vector(4, -3, 2);
        // (-2*4) + (3*-3) + (-4*2) = -8 -9 -8 = -25
        assertEquals(-25, sp.calculateScalarProduct(v1, v2));
    }
}