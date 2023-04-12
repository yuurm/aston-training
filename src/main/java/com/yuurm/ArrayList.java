package com.yuurm;

import java.util.Comparator;

/**
 * 12.04.2023
 * hw1
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
     * Instantiates a new Array list.
     */
    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            System.err.println("Out of bounds");
            return null;
        }
    }

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

    @Override
    public void add(T element) {

        if (size == elements.length) {
            resize();
        }

        this.elements[size] = element;
        size++;
    }

    private void resize() {

        T[] newElements = (T[]) new Object[elements.length + elements.length / 2];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

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
     *
     * @param comparator the comparator
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

    private void addAll(ArrayList<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            T element = elements.get(i);
            add(element);
        }

    }

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

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
}