package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * @author yuurm
 * @version v1.0
 *
 * A list is a collection where the order in which items are added is maintained.
 * If you add an item as number 6, it will be available as number 6.
 */

public interface List<T> extends Collection<T> {

    /**
     * Returns the element with the given index
     * @param index index element
     * @return item
     */
    T get(int index);

    /**
     * Inserts the specified element at the beginning of this list.
     * @param element
     */

    void addFirst(T element);


}
