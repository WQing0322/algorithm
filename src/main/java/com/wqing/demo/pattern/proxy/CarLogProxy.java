package com.wqing.demo.pattern.proxy;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class CarLogProxy implements MoveApi {
    private MoveApi moveApi;

    public CarLogProxy(MoveApi moveApi) {
        super();
        this.moveApi = moveApi;
    }

    @Override
    public void move() {
        System.out.println("我是日志代理");
        System.out.println("日志打印开始......");
        long startTime = System.currentTimeMillis();
        moveApi.move();
        long endTime = System.currentTimeMillis();
        System.out.println("日志打印结束，用时:" + (endTime - startTime) + "毫秒");
    }
}
