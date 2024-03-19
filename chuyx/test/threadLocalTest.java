package test;

/**
 * @author yuxiang_chu
 * @since 2024/2/21 14:15
 */
public class threadLocalTest {

    static ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();

    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        objectThreadLocal.set("213");
        integerThreadLocal.set(1);

        test2();
    }

    private static void test2() {
        System.out.println(objectThreadLocal.get());
        System.out.println(integerThreadLocal.get());
    }
}
