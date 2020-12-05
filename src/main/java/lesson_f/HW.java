package lesson_f;

import java.util.ArrayList;

public class HW {
    private Object RuntimeException;

    public static void main(String[] args) {
        // Написать метод, который проверяет состав массива из чисел 1 и 4.
        // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
        // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    }

    public static boolean hw2(Integer[] arr) {
        int counter_one = 0;
        int counter_four = 0;
        for (int i : arr) {
            if (i == 1)
                counter_one++;
            else if (i == 4)
                counter_four++;
        }
        return counter_one > 0 && counter_four > 0;
    }

    public static Integer[] hw1(Integer[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int counter = 0;
        for (int i : arr) {
            if (i == 4)
                counter++;
        }
        if (counter == 0)
            throw new RuntimeException();
        for (int i : arr) {
            if (counter == 0) {
                newArr.add(i);
            }
            if (i == 4)
                counter--;
        }
        return newArr.toArray(new Integer[0]);
    }
}
