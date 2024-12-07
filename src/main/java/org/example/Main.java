package org.example;

public class Main {
    public static void main(String[] args) {
        CarLinkedList carLinkedList = new CarLinkedList();
        carLinkedList.add(new Car("Машина", "Синяя"));
        carLinkedList.clear();
        carLinkedList.add(new Car("Трактор", "Синий"), 0);
        carLinkedList.add(new Car("Грузовик", "Красный"), 1);
        carLinkedList.add(new Car("Последний", "В списке"));
        carLinkedList.add(new Car("Встанет", "Вторым"), 1);
        //carLinkedList.removeAt(2);
        //carLinkedList.remove(new Car("Трактор", "Синий"));
        for (int i = 0; i < carLinkedList.size(); i++) {
            System.out.println(carLinkedList.get(i).getModel() + " -> "
                    + carLinkedList.get(i).getColor());
        }
    }
}