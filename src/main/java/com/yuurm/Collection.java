package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * @author yuurm
 * @version v1.0
 *
 * This interface implies the ability to save items in any set
 * The order (whom and after whom you added the items) does not play a role
 */
public interface Collection<T> {
    /**
     * Adds element to the collection
     * @param element to be added
     */
    void add(T element);

    /**
     * Checks if the element is in the collection
     * @param element is the item you are looking for
     * @return true if element is present at least once in the collection
     */
    boolean contains(T element);

    /**
     * Get the number of elements in the collection
     * @return returns number of elements
     */
    int size();

    /**
     * Deletes the first occurrence of an element in the list
     * @param element to be deleted
     */
    void remove(T element);


    /**
     *
     * Returns an iterator over the elements in Collection.
     * @return an iterator over the elements in Collection
     */

    Iterator<T> iterator();
}