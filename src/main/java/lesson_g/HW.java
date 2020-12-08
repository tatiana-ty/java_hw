package lesson_g;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class HW {
    @Test
    public void hw () {
        System.out.println("test1");
    }

    @BeforeSuite
    public void hw1 () {
        System.out.println("before");
    }

    @AfterSuite
    public void hw2 () {
        System.out.println("after");
    }

    @Test
    public void hw3 () {
        System.out.println("test2");
    }

    public static void start(Class testClass) throws Exception {
        int before = 0;
        int after = 0;
        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> mBefore = new ArrayList<>();
        ArrayList<Method> mAfter = new ArrayList<>();
        ArrayList<Method> mTest = new ArrayList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before++;
                mBefore.add(m);
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                after++;
                mAfter.add(m);
            } else if (m.isAnnotationPresent(Test.class)) {
                mTest.add(m);
            }
        }
        if (before > 1 || after > 1) {
            throw new RuntimeException();
        }
        Object c = testClass.getDeclaredConstructor().newInstance();

        for (Method m : mBefore) m.invoke(c);
        for (Method m : mTest) m.invoke(c);
        for (Method m : mAfter) m.invoke(c);
    }

    public static void main(String[] args) throws Exception {
        start(HW.class);
    }
}
