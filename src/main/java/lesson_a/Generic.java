package lesson_a;

import java.util.ArrayList;

public class Generic<T> {
    private T[] vars;

    public Generic(T... vars) {
        this.vars = vars;
    }

    // 1
    public void replace(int i1, int i2) {
        T temp = vars[i1];
        vars[i1] = vars[i2];
        vars[i2] = temp;

        for (T var : vars) {
            System.out.print(var + ", ");
        }
        System.out.println();
    }

    // 2
    public ArrayList<T> toArray () {
        ArrayList<T> arr = new ArrayList<T>();
        for (T var : vars) {
            arr.add(var);
        }
        return arr;
    }
}
