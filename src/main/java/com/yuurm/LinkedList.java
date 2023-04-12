package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * @param <T> the type parameter
 * @author yuurm
 * @version v1.0
 */
public class LinkedList<T> implements List<T> {

    private static class Node<T> {
        /**
         * The Value.
         */
        T value;
        /**
         * The Next.
         */
        Node<T> next;

        /**
         * Instantiates a new Node.
         *
         * @param value the value
         */
        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> first;

    private Node<T> last;

    private int size;

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            Node<T> current = first;

            for (int i = 0; i < index; i++) {

                current = current.next;
            }

            return current.value;
        }
        System.err.println("Index out of bounds");
        return null;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element);
        if (first == null) {
            add(element);
        } else {

            newNode.next = first;

            first = newNode;
            size++;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<T>(element);

        if (first == null) {

            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;

        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(T element) {
        Node<T> prev = null;
        Node<T> curr = first;

        while (curr != null) {
            if (curr.value.equals(element)) {
                if (prev == null) {
                    first = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = first;

        @Override
        public T next() {

            T element = current.value;

            current = current.next;

            return element;
        }

        @Override
        public boolean hasNext() {

            return current != null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}




