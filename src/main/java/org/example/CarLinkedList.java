package org.example;

import java.util.Objects;

/**
 * Связанный список автомобилей
 */
public class CarLinkedList implements CarList {
    /**
     * Первый элемент коллекции
     */
    private Node first;
    /**
     * Последний элемент коллекции
     */
    private Node last;
    /**
     * Количество экземпляров коллекции
     */
    private int size = 0;

    /**
     * Получение экземпляра коллекции по индексу
     * @param index индекс
     * @return элемент коллекции с указанным индексом
     */
    @Override
    public Car get(int index) {
        return getNote(index).value;
    }

    /**
     * Добавление экземпляра в конец списка
     * @param car экземпляр автомобиля
     */
    @Override
    public void add(Car car) {
        add(car, size);
    }

    /**
     * Добавление экземпляра с индексом
     * @param car экземпляр автомобиля
     * @param index индекс в списке
     */
    @Override
    public void add(Car car, int index) {
        // Проверка на выход из диапазона значений
        outOfRangeCheck(index);

        // Получаем текущий узел
        Node nowNode;

        // Создаём новый узел
        Node newNode;

        if (index != size || first == null) {
            if (index != 0) {
                nowNode = getNote(index);
                // Создание "в середине" списка
                newNode = new Node(nowNode.previous, car, nowNode);
                // Перераспределение ссылок для элемента "в середине"
                if (nowNode.previous != null) {
                    nowNode.previous.next = newNode;
                    nowNode.previous = newNode;
                }
            }
            else {
                // Для первого элемента
                newNode = new Node(null, car, null);
                first = newNode;
            }
        }
        else {
            // Создание последнего элемента
            nowNode = getNote(index - 1);
            newNode = new Node(nowNode, car, null);
            nowNode.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Удаление элемента по значению
     * @param car экземпляр автомобиля
     * @return true - удалено; false - не удалось удалить
     */
    @Override
    public boolean remove(Car car) {
        int index = getIndex(car);
        if (index < 0) {
            return false;
        }
        else {
            return removeAt(index);
        }
    }

    /**
     * Удаление элемента по индексу
     * @param index индекс элемента
     * @return true - удалено; false - не удалось удалить
     */
    @Override
    public boolean removeAt(int index) {
        // Проверка на выход из диапазона
        outOfRangeCheck(index);
        // Получаем удаляемый узел
        Node removeNode = getNote(index);
        // Если есть хотя бы одил элемент
        if (size > 0) {
            if (removeNode.previous != null) {
                removeNode.previous.next = removeNode.next;
            }
            else {
                first = removeNode.next;
            }
            if (removeNode.next != null) {
                removeNode.next.previous = removeNode.previous;
            }
            else {
                last = removeNode.previous;
            }
            size--;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Получение количества элементов справочника
     * @return количество элементов
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Очистка справочника
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * Проверка на выход из диапазона значений
     * @param index индекс элемента
     */
    private void outOfRangeCheck(int index) {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Получение узла
     * @param index индекс узла
     * @return узел
     */
    private Node getNote(int index) {
        if (first == null) {
            return null;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Получение индекса в списке
     * @param car экземпляр атомобиля
     * @return индекс указанного автомобиля в списке
     */
    private int getIndex(Car car) {
        if (first == null) {
            return -1;
        }

        Node node = first;
        for (int i = 0; i < size-1; i++) {
            if (Objects.equals(node.value.getModel(), car.getModel())
                    && Objects.equals(node.value.getColor(), car.getColor())) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    /**
     * Структура узлов
     */
    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
