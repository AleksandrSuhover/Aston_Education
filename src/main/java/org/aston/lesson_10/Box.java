package org.aston.lesson_10;

import java.util.List;

public class Box<T extends Fruit>  {
    private final List<T> listFruits;

    public Box(List<T> listFruits) {
        this.listFruits = listFruits;
    }

    public void addFruitToBox(T fruit ){
        this.listFruits.add(fruit);
    }

    public double getWeight(){
        return this.listFruits.isEmpty() ? 0
                                         : this.listFruits.size() * this.listFruits.get(0).getWeight();
    }

    public boolean compare(Box<?> secondBox){
        return getWeight() == secondBox.getWeight();
    }

    public void putFruitInAnotherBox(Box<T> secondBox){
        for(T fruit : this.listFruits){
            secondBox.addFruitToBox(fruit);
        }
        this.listFruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "listFruits=" + listFruits +
                '}';
    }
}
