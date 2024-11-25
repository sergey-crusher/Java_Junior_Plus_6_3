package org.example;

public class Main {
    public static void main(String[] args) {
        CarLinkedList carLinkedList = new CarLinkedList();
        carLinkedList.add(new Car("Машина", "Синяя"), 0);
        carLinkedList.add(new Car("Трактор", "Синий"), 1);
        carLinkedList.add(new Car("Грузовик", "Красный"), 2);
        carLinkedList.add(new Car("Последний", "В списке"));
        carLinkedList.add(new Car("Встанет", "Вторым"), 1);
        for (int i = 0; i < carLinkedList.size(); i++) {
            System.out.println(carLinkedList.get(i).getModel() + " -> "
                    + carLinkedList.get(i).getColor());
        }
    }
}