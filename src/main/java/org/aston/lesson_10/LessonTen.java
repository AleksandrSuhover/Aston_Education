package org.aston.lesson_10;

import java.util.ArrayList;

public class LessonTen {
    public static void executeLesson10(){
        Box<Apple> appleBox = new Box<>(new ArrayList<>());
        appleBox.addFruitsToBox(new Apple());
        appleBox.addFruitsToBox(new Apple());
        appleBox.addFruitsToBox(new Apple());
        System.out.println(appleBox);
        System.out.println(appleBox.getWeight());               // Получаем вес коробки с яблоками

        Box<Orange> orangeBox = new Box<>(new ArrayList<>());
        orangeBox.addFruitsToBox(new Orange());
        orangeBox.addFruitsToBox(new Orange());
        System.out.println(orangeBox);
        System.out.println(orangeBox.getWeight());              // Получаем вес коробки с апельсинами

        System.out.println(appleBox.compare(orangeBox));        // Сравниваем две коробки с фруктами

        Box<Apple> appleBox2 = new Box<>(new ArrayList<>());
        appleBox.putFruitInAnotherBox(appleBox2);               // Перекидываем фрукты из одной коробки в другую
        System.out.println(appleBox);
        System.out.println(appleBox2);
    }
}
