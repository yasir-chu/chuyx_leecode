package test.lock.TestHaMapDead;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuxiang.chu
 * @date 2022/6/21 9:50
 **/
public class ForHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> result = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            result.put(UUID.randomUUID().toString(),"");
                        }
                    },"fit-i").start();
                }
            }
        },"fit-");
        t.start();
        t.join();
    }
}
