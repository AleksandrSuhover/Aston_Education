package org.aston.lesson_10;

public class Orange extends Fruit{

    public Orange() {
        super(1.5);
    }

    @Override
    public String toString() {
        return "Orange, weight " + getWEIGHT_FRUIT();
    }
}
