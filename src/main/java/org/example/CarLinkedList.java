package org.example;

public class CarLinkedList implements CarList {
    private Node first;
    private Node last;
    private int size = 0;

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
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
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

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

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
