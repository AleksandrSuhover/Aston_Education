package org.aston.lesson_5;

public class Cat extends Animal{

    private static int catCounter = 0;

    public Cat(String name){
        super(name, 200, 0, true);
        ++catCounter;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", MAX_DISTANCE_TO_RUN=" + MAX_DISTANCE_TO_RUN +
                ", MAX_DISTANCE_TO_SWIM=" + MAX_DISTANCE_TO_SWIM +
                '}';
    }

    public static int getCatCounter() {
        return catCounter;
    }
}
