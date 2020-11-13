package ru.geekbrains.java_three.lesson_a;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 1
        Generic<String> sArr = new Generic<String>("a", "b", "c", "d", "e");
        Generic<Integer> iArr = new Generic<Integer>(1, 2, 3, 4, 5);
        Generic<Double> dArr = new Generic<Double>(1.0, 2.0, 3.0, 4.0, 5.0);

        sArr.replace(0, 3);
        iArr.replace(1, 4);
        dArr.replace(0, 2);
        //------------------------//

        // 2
        ArrayList<String> arr = sArr.toArray();
        System.out.println(arr.getClass());
        //------------------------//

        // 3
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Orange orange = new Orange();

        // add examples
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple);
        //appleBox.addFruit(orange);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange);
        //orangeBox.addFruit(apple);

        // getWeight examples
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        // move example
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(apple1);
        appleBox1.move(appleBox);
        System.out.println(appleBox.getWeight());
        //appleBox.move(orangeBox);
    }



}
