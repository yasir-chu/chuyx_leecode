package test.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuxiang.chu
 * @date 2022/8/31 17:50
 **/
public class ThreadPoolWorkerStateTest {


    public static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) {

    }
}
