package org.aston.lesson_10;

public class Apple extends Fruit{

    public Apple() {
        super(1.0);
    }

    @Override
    public String toString() {
        return "Apple, weight: " + getWEIGHT_FRUIT();
    }
}
