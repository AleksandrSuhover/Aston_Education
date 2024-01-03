package org.aston.lesson_5;

public class Dog extends Animal{

    private static int dogCounter = 0;

    public Dog(String name){
        super(name, 500, 10, true);
        ++dogCounter;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", MAX_DISTANCE_TO_RUN=" + MAX_DISTANCE_TO_RUN +
                ", MAX_DISTANCE_TO_SWIM=" + MAX_DISTANCE_TO_SWIM +
                '}';
    }

    public static int getDogCounter() {
        return dogCounter;
    }
}
