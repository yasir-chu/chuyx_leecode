package test.lock.FairNoFairTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuxiang.chu
 * @date 2022/6/20 18:22
 **/
public class FairAndUnfairTest {

    public static Lock fairLock = new ReentrantLock(true);
    public static Lock noFairLock = new ReentrantLock(false);


    public static void main(String[] args) {
        testLock(fairLock);
//        System.out.println("-----------------------------------------------------");
//        testLock(noFairLock);
    }

    private static void testLock(Lock lock) {
        for (int i = 0; i < 50; i++) {
            Job job = new Job(lock);
            job.start();
        }
    }

    static class Job extends Thread {

        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());

            }finally {
                lock.unlock();
            }
        }
    }
}
