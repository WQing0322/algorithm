package com.wqing.demo.thread;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class ThreadTask implements Runnable {
    private final int busId;

    public ThreadTask(int busId) {
        this.busId = busId;
    }

    public void run() {
        System.out.println("任务" + busId + "开始运行");
    }
}
