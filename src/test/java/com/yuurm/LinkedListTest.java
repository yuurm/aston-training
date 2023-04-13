package com.yuurm;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 12.04.2023
 * hw1
 *
 * @author yuurm
 * @version v1.0
 *
 * The type Linked list test.
 */
class LinkedListTest {

    private LinkedList<Integer> list;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    /**
     * Test add and get.
     */
    @Test
    void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * Test add first.
     */
    @Test
    void testAddFirst() {
        list.add(1);
        list.addFirst(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    /**
     * Test contains.
     */
    @Test
    void testContains() {
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
    void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
    }

    /**
     * Test remove.
     */
    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
        assertTrue(list.contains(1));
        assertTrue(list.contains(3));
    }

    /**
     * Test iterator.
     */
    @Test
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter =  list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
    }
}
