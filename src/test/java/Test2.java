import org.junit.*;
import lesson_f.*;

public class Test2 {
    @Test
    public void test1() {
        Assert.assertTrue(HW.hw2(new Integer[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void test2() {
        Assert.assertTrue(HW.hw2(new Integer[]{1, 4, 1, 4, 1, 1}));
    }

    @Test
    public void test3() {
        Assert.assertFalse(HW.hw2(new Integer[]{1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void test4() {
        Assert.assertFalse(HW.hw2(new Integer[]{4, 4, 4, 4, 4, 4}));
    }
}
