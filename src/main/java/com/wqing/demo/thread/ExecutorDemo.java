package com.wqing.demo.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class ExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new ThreadPoolExecutor()

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<?>> futureList = new LinkedList<Future<?>>();
        for (int i = 0; i < 10; i++) {
            System.out.println("任务" + i + "加入线程池");
            futureList.add(executorService.submit(new ThreadTask(i)));
        }

        for (Future<?> future : futureList) {
            System.out.println("返回结果" + future.get());
        }

        System.out.println("任务结束。");
        executorService.shutdown();
    }
}
