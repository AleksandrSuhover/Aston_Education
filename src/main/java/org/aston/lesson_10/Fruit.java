package org.aston.lesson_10;

public class Fruit {
    private final double WEIGHT_FRUIT;

    public Fruit(double weightFruit) {
        WEIGHT_FRUIT = weightFruit;
    }

    public double getWEIGHT_FRUIT() {
        return WEIGHT_FRUIT;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "WEIGHT_FRUIT=" + WEIGHT_FRUIT +
                '}';
    }
}
