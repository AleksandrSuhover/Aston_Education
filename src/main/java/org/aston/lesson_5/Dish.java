package org.aston.lesson_5;

public class Dish {
    private int amountOfFood;

    public Dish(int amountOfFood){
        this.amountOfFood = Math.max(amountOfFood, 0);
    }

    public void addFoodToDish(int quantityFood){
        if(quantityFood > 0) {
            this.amountOfFood += quantityFood;
        } else {
            System.out.println("Введенно некорректное значение еды.");
        }
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void removeAllFoodFromDish(){
        this.amountOfFood = 0;
    }
}
