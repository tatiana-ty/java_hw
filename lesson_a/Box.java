package ru.geekbrains.java_three.lesson_a;

import java.util.ArrayList;

public class Box<T extends Fruit & NonMixable> {
    private ArrayList<T> box = new ArrayList<>();

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        return box.size() == 0 ? 0 : box.get(0).getWeight() * box.size();
    }

    public boolean compare(Box<?> another) {
        return this.getWeight() == another.getWeight();
    }

    public void move (Box<T> another) {
        another.box.addAll(this.box);
    }

}
