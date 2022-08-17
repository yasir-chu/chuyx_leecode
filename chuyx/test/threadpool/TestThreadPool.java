package test.threadpool;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author yuxiang.chu
 * @date 2022/8/17 15:05
 **/
public class TestThreadPool {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor() {
        return new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.submit(() -> {
                threadPoolStatus(threadPoolExecutor, "创建任务");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolStatus(threadPoolExecutor, "改变前");
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolExecutor.prestartCoreThread();//启动所有的核心线程数
        threadPoolStatus(threadPoolExecutor, "改变后");
        Thread.currentThread().join();
    }

    private static void threadPoolStatus(ThreadPoolExecutor executor, String name) {
        LinkedBlockingQueue queue = (LinkedBlockingQueue)executor.getQueue();
        System.out.println(Thread.currentThread().getName() + "-" + name + ":-" +
                "核心线程数：" +executor.getCorePoolSize() +
                "活动线程数：" + executor.getActiveCount() +
                "最大线程数：" + executor.getMaximumPoolSize() +
                "线程池活跃度：" +
                divide(executor.getActiveCount(), executor.getMaximumPoolSize()) +
                "任务完成数：" + executor.getCompletedTaskCount() +
                "队列大小：" + (queue.size() + queue.remainingCapacity()) +
                "当前排队线程数" + queue.size() +
                "队列剩余大小" + queue.remainingCapacity() +
                "队列使用度" +divide(queue.size(), queue.size() + queue.remainingCapacity())
        );
    }

    private static String divide(int num1, int nums2) {
        return String.format("%1.2f%%", Double.parseDouble(num1+"")/Double.parseDouble(nums2+"") * 100);
    }

}
