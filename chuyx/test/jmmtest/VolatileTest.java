package test.jmmtest;

import java.util.concurrent.TimeUnit;

/**
 * volatile 修饰的变量测试
 *
 * @author yuxiang_chu
 * @date 2022/12/16 14:46
 */
public class VolatileTest {

    private static volatile int testNum = 0;


    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            testNum ++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            MyThread myThread = new MyThread();
            myThread.start();
        }
        Thread.sleep(5000);

        System.out.println(testNum);
    }

}
