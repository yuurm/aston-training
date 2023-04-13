package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * An iterator over a collection of elements of type T.
 *
 * @param <T> the type of elements returned by this iterator
 * @author yuurm
 * @version v1.0
 */
public interface Iterator<T> {
    /**
     * go to the next element
     *
     * @return element t
     */
    T next();
    /**
     * check if there is a following element
     *
     * @return true if there is a next item, false if there is no next item
     */
    boolean hasNext();
}
