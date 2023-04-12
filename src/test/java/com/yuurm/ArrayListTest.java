package com.yuurm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
/**
 * 12.04.2023
 * hw1
 *
 * @author yuurm
 * @version v1.0
 *
 * The type Array list test.
 */
public class ArrayListTest {

    private ArrayList<Integer> list;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
    }

    /**
     * Test get.
     */
    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertNull(list.get(3));
    }

    /**
     * Test add first.
     */
    @Test
    public void testAddFirst() {
        list.add(1);
        list.add(2);
        list.addFirst(3);
        assertEquals(3, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
    }

    /**
     * Test add.
     */
    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * Test contains.
     */
    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    /**
     * Test size.
     */
    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    /**
     * Test remove.
     */
    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        list.remove(4);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    /**
     * Test quick sort.
     */
    @Test
    public void testQuickSort() {
        list.add(3);
        list.add(2);
        list.add(1);
        list.quickSort(Comparator.naturalOrder());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * Test iterator.
     */
    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            sum += element;
        }
        assertEquals(6, sum);
    }

}
