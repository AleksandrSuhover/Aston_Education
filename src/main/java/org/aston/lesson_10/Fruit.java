package org.aston.lesson_10;

public class Fruit {
    private final String NAME_FRUIT;
    private final double WEIGHT_FRUIT;

    public Fruit(String nameFruit, double weightFruit) {
        NAME_FRUIT = nameFruit;
        WEIGHT_FRUIT = weightFruit;
    }

    public double getWeight() {
        return WEIGHT_FRUIT;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "NAME_FRUIT='" + NAME_FRUIT + '\'' +
                ", WEIGHT_FRUIT=" + WEIGHT_FRUIT +
                '}';
    }
}
