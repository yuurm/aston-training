package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * Implementation of a linked list that implements the List interface.
 * @param <T> the type parameter
 * @author yuurm
 * @version v1.0
 */
public class LinkedList<T> implements List<T> {

    /**
     *
     * Class representing a node in the linked list.
     * @param <T> the type parameter
     */

    private static class Node<T> {
        /**
         * The Value.
         */
        T value;
        /**
         * The Next node in the list.
         */
        Node<T> next;

        /**
         * Instantiates a new Node.
         *
         * @param value the value to be stored in the node
         */
        public Node(T value) {
            this.value = value;
        }
    }

    /**
     *
     * The first node in the list.
      */

    private Node<T> first;

    /**
     *
     * The last node in the list.
     */
    private Node<T> last;

    /**
     * The size of the list.
     */

    private int size;

    /**
     *
     * Gets the element at the specified index in the list.
     *
     * @param index the index of the element to retrieve
     *
     * @return the element at the specified index
     */

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


    /**
     *
     * Adds the specified element to the beginning of the list.
     *
     * @param element the element to add to the beginning of the list
     */

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

    /**
     *
     * Adds the specified element to the end of the list.
     *
     * @param element the element to add to the end of the list
     */

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

    /**
     *
     * Checks if the list contains the specified element.
     *
     * @param element the element to check for
     *
     * @return true if the element is in the list, false otherwise
     */

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

    /**
     *
     * Returns the number of elements in the list.
     *@return the number of elements in the list
     */

    @Override
    public int size() {
        return size;
    }

    /**
     *
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to remove from the list
     */

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

    /**
     *
     * Returns an iterator over the elements in this LinkedList.
     * @return an iterator over the elements in this LinkedList
     */

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}




