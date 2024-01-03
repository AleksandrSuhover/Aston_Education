package org.aston.lesson_5;

public class Animal {
    String name;
    private Boolean satiety = false;
    Boolean isEatFromDish = false;
    final int MAX_DISTANCE_TO_RUN;
    final int MAX_DISTANCE_TO_SWIM;
    private static int counterAnimal = 0;


    public Animal(String name, int MAX_DISTANCE_TO_RUN, int MAX_DISTANCE_TO_SWIM, boolean isEatFromDish) {
        this.name = name;
        this.MAX_DISTANCE_TO_RUN = MAX_DISTANCE_TO_RUN;
        this.MAX_DISTANCE_TO_SWIM = MAX_DISTANCE_TO_SWIM;
        this.isEatFromDish = isEatFromDish;
        ++counterAnimal;
    }

    public String run(int distanceInMeters) {
        if (MAX_DISTANCE_TO_RUN == 0) return "Животное по кличке " + this.name + " бегать не умеет.";
        if (distanceInMeters <= 0) return "Введены некоректные данные для бега.";
        return distanceInMeters > MAX_DISTANCE_TO_RUN ? this.name + " не может пробежать такое расстояние. "
                                                      : "Животное по кличке " + this.name + " пробежало " + distanceInMeters + " метров.";
    }

    public String swim(int distanceInMeters) {
        if (MAX_DISTANCE_TO_SWIM == 0) return "Животное по кличке " + this.name + " плавать не умеет.";
        if (distanceInMeters <= 0) return "Введены некоректные данные для плавания.";
        return distanceInMeters > MAX_DISTANCE_TO_SWIM ? this.name + " не может проплыть такое расстояние."
                                                       : "Животное по кличке " + this.name + " проплыло " + distanceInMeters + " метров.";
    }

    public String eatFromDish(Dish dishOfFood, int appetite) {
        if(!this.isEatFromDish){
            return "Животное по кличке " + this.name + " не умеет есть из миски";
        }
        if (dishOfFood.getAmountOfFood() < appetite) {
            return "Животному по кличке " + this.name + " не хватило еды.";
        } else {
            dishOfFood.setAmountOfFood(dishOfFood.getAmountOfFood() - appetite);
            setSatiety(true);
            return "Животное по кличке " + this.name + " насытилось.";
        }

    }

    public static int getCounterAnimal() {
        return counterAnimal;
    }

    public void setSatiety(Boolean satiety) {
        this.satiety = satiety;
    }

    public Boolean getSatiety() {
        return satiety;
    }
}
