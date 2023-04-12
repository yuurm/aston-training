package com.yuurm;

/**
 * 12.04.2023
 * hw1
 *
 * @author yuurm
 * @version v1.0
 *
 * Список это такая коллекция, где сохраняется порядок добавления элементов.
 * Если вы добавили элемент 6-м, то он и будет доступен под 6-м номеров
 */

public interface List<T> extends Collection<T> {

    /**
     * Возвращает элемент под заданным индексом
     * @param index индекс элемента
     * @return элемент
     */
    T get(int index);

    void addFirst(T element);
}
