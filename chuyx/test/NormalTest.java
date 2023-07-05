package test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author yuxiang.chu
 * @date 2022/8/30 10:12
 **/
public class NormalTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
//        FutureTask<String> futureTask = new FutureTask<>(() -> {
//            Thread.sleep(2000);
//            return UUID.randomUUID().toString();
//        });
//        new Thread(futureTask).start();
//        CompletableFuture<String> stringCompletableFuture = CompletableFuture.completedFuture(futureTask.get());
//        String s = stringCompletableFuture.get();
//        System.out.println(s);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                return UUID.randomUUID().toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        });
        future.whenComplete((uuid, exception) -> {
            System.out.println(uuid);
            System.out.println("2:" + Thread.currentThread().getName());
        });


        System.out.println(111111);
        System.in.read();
    }




}
