package org.aston.lesson_5;

import org.aston.utils.ObjectUtils;

import java.util.ArrayList;

public class LessonFive {

    public static void executeLesson5(){

        //Task № 1.1
        Cat catBarsik = new Cat("Барсик");
        System.out.println(catBarsik.run(22));
        System.out.println(catBarsik.swim(2));

        Dog dogRex = new Dog("Рэкс");
        System.out.println(dogRex.run(22));
        System.out.println(dogRex.swim(2));

        Dog dogMike = new Dog("Майк");
        System.out.println(dogMike.run(550));
        System.out.println(dogMike.swim(11));

        System.out.println(Cat.getCatCounter());
        System.out.println(Dog.getDogCounter());
        System.out.println(Animal.getCounterAnimal());

        //Task № 1.2
        Dish firstDish = new Dish(15);
        firstDish.addFoodToDish(20);
        System.out.println(firstDish.getAmountOfFood());

        ArrayList<Cat> arrayTestCats = ObjectUtils.createArrayTestCat(5);
        for (Cat testCat : arrayTestCats) {
            System.out.println(testCat.eatFromDish(firstDish, 10));
            System.out.println("Кот по кличке " + testCat.name + " сыт: " + testCat.getSatiety());
        }

        //Task № 2

        Figure square = new Square(Color.GREEN, Color.BLUE, 45);
        System.out.println(square);

        Figure triangle = new Triangle(Color.BLUE, Color.GREEN, 10, 10, 10);
        System.out.println(triangle);

        Figure circle = new Circle(Color.RED, Color.BLACK, 20);
        System.out.println(circle);
    }

}
