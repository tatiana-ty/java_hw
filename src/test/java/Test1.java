import org.junit.*;
import lesson_f.*;

public class Test1 {
    @Test
    public void test1() {
        Assert.assertEquals(new Integer[]{1, 7}, HW.hw1(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(new Integer[]{}, HW.hw1(new Integer[]{4}));
    }

    @Test(expected = RuntimeException.class)
    public void test3() {
        Assert.assertEquals(new Integer[]{}, HW.hw1(new Integer[]{1, 2, 3, 5, 6, 8}));
    }

    @Test(expected = RuntimeException.class)
    public void test4() {
        Assert.assertEquals(new Integer[]{}, HW.hw1(new Integer[]{}));
    }

}
