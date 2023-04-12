package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * @param <T> the type parameter
 * @author yuurm
 * @version v1.0
 */
public interface Iterator<T> {
    /**
     * перейти к следующему элементу
     *
     * @return элемент t
     */
    T next();

    /**
     * проверить, есть ли следующий элемент
     *
     * @return true если следующий элемент есть, false - если следующего элемента нет
     */
    boolean hasNext();
}
