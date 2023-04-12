package com.yuurm;

import java.util.Comparator;

/**
 * 12.04.2023
 * hw1
 * ArrayList implementation of the List interface.
 * This class implements a resizable array that stores elements of a given generic type.
 *
 * @param <T> the type parameter
 * @author yuurm
 * @version v1.0
 */


public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;

    private T[] elements;

    private int size;

    /**
     * Constructs an empty ArrayList with a default capacity of 10.
     */
    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            System.err.println("Out of bounds");
            return null;
        }
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param element the element to insert
     */
    @Override
    public void addFirst(T element) {
        if (size == elements.length) {
            resize();
        }

        for (int i = size + 1; i > 0; i--) {
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[0] = element;
        size++;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element the element to append
     */

    @Override
    public void add(T element) {

        if (size == elements.length) {
            resize();
        }

        this.elements[size] = element;
        size++;
    }


    /**
     * Resizes the underlying array by increasing its capacity by 50%.
     */

    private void resize() {

        T[] newElements = (T[]) new Object[elements.length + elements.length / 2];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }


    /**
     * Returns true if this list contains the specified element.
     *
     * @param element the element to check for containment
     * @return true if this list contains the specified element
     */

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If the list does not contain the element, it is unchanged.
     *
     * @param element the element to be removed from this list, if present
     */
    @Override
    public void remove(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            T[] newElements = (T[]) new Object[size];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            this.elements = newElements;
        }
    }


    /**
     * Quick sort.
     * <p>
     * Sorts the elements in the ArrayList using the quick sort algorithm, based on the order specified by the given comparator.
     *
     * @param comparator the comparator to use for the sorting
     */

    public void quickSort(Comparator<T> comparator) {
        if (size() <= 1) {
            return;
        }
        T pivot = get(size() / 2);
        ArrayList<T> less = new ArrayList<>();
        ArrayList<T> equal = new ArrayList<>();
        ArrayList<T> greater = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            T element = get(i);
            int compareResult = comparator.compare(element, pivot);
            if (compareResult < 0) {
                less.add(element);
            } else if (compareResult == 0) {
                equal.add(element);
            } else {
                greater.add(element);
            }
        }

        less.quickSort(comparator);
        greater.quickSort(comparator);

        clear();
        addAll(less);
        addAll(equal);
        addAll(greater);
    }

    /**
     * dds all elements from the specified ArrayList to this ArrayList.
     *
     * @param elements the ArrayList whose elements to add
     */

    private void addAll(ArrayList<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            T element = elements.get(i);
            add(element);
        }

    }

    /**
     * Removes all elements from this ArrayList.
     */

    private void clear() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }


    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public T next() {

            T element = elements[current];

            current++;

            return element;
        }

        @Override
        public boolean hasNext() {

            return current < size;
        }
    }

    /**
     *
     * Returns an iterator over the elements in this ArrayList.
     * @return an iterator over the elements in this ArrayList
     */

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
}