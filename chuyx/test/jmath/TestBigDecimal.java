package test.jmath;

import java.math.BigDecimal;

/**
 * @author yuxiang.chu
 * @date 2022/6/1 9:53
 **/
public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1");
        new BigDecimal(1.11);
        BigDecimal bigDecimal7 = new BigDecimal("3");
        BigDecimal bigDecimal6 = bigDecimal.divide(bigDecimal7, 10, BigDecimal.ROUND_DOWN);
        BigDecimal bigDecimal2 = new BigDecimal("1.234");
        BigDecimal bigDecimal3 = new BigDecimal("1.2345");
        BigDecimal bigDecimal4 = new BigDecimal("1.23456");
        System.out.println(bigDecimal);
    }
}
