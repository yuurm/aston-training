package com.yuurm;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArrayListTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ArrayList}
     *   <li>{@link ArrayList#size()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals(0, (new ArrayList<>()).size());
    }

    /**
     * Method under test: {@link ArrayList#get(int)}
     */
    @Test
    void testGet() {
        assertNull((new ArrayList<>()).get(1));
        assertNull((new ArrayList<>()).get(-1));
    }

    /**
     * Method under test: {@link ArrayList#get(int)}
     */
    @Test
    void testGetString() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst("Element");
        arrayList.addFirst("Element");
        assertEquals("Element", arrayList.get(1));
    }

    /**
     * Method under test: {@link ArrayList#addFirst(Object)}
     */
    @Test
    void testAddFirst() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst("Element");
        assertEquals(1, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#add(Object)}
     */
    @Test
    void testAdd() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("Element");
        assertEquals(1, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#contains(Object)}
     */
    @Test
    void testContains() {
        assertFalse((new ArrayList<>()).contains("Element"));
    }

    /**
     * Method under test: {@link ArrayList#contains(Object)}
     */
    @Test
    void testContainsString() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst("Element");
        assertTrue(arrayList.contains("Element"));
    }

    /**
     * Method under test: {@link ArrayList#contains(Object)}
     */
    @Test
    void testContainsAndAddFirst() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst(2);
        assertFalse(arrayList.contains("Element"));
    }

    /**
     * Method under test: {@link ArrayList#remove(Object)}
     */
    @Test
    void testRemove() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.remove("Element");
        assertEquals(0, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#remove(Object)}
     */
    @Test
    void testRemoveAndAddFirst() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst("Element");
        arrayList.remove("Element");
        assertEquals(0, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#remove(Object)}
     */
    @Test
    void testRemoveAndAddFirstString() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst("Element");
        arrayList.addFirst("Element");
        arrayList.remove("Element");
        assertEquals(1, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#remove(Object)}
     */
    @Test
    void testRemoveAbsent() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addFirst(2);
        arrayList.remove("Element");
        assertEquals(1, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#quickSort(Comparator)}
     */
    @Test
    void testQuickSort() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.quickSort((Comparator<Object>) mock(Comparator.class));
        assertEquals(0, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#addAll(ArrayList)}
     */
    @Test
    void testAddAll() {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<Object> arrayList1 = new ArrayList<>();
        arrayList.addAll(arrayList1);
        assertEquals(0, arrayList1.size());
        assertEquals(0, arrayList.size());
    }



    /**
     * Method under test: {@link ArrayList#addAll(ArrayList)}
     */
    @Test
    void testAddAllAnotherList() {
        ArrayList<Object> arrayList = new ArrayList<>();

        ArrayList<Object> arrayList1 = new ArrayList<>();
        arrayList1.addFirst("Element");
        arrayList.addAll(arrayList1);
        assertEquals(1, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#clear()}
     */
    @Test
    void testClear() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    /**
     * Method under test: {@link ArrayList#iterator()}
     */
    @Test
    void testIterator() {
        List<Integer> list = new ArrayList<>();
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

