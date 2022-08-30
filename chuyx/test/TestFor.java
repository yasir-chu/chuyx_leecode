package test;

/**
 * @author yuxiang.chu
 * @date 2022/8/30 10:12
 **/
public class TestFor {

    public static void main(String[] args) {
        lop:
        for (;;) {
            for (;;) {
                System.out.println("1");
                break lop;
            }
        }
    }
}
