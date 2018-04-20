package com.wqing.demo.pattern.proxy;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class CarTimeProxy implements MoveApi {
    private MoveApi moveApi;

    public CarTimeProxy(MoveApi moveApi) {
        super();
        this.moveApi = moveApi;
    }

    @Override
    public void move() {
        System.out.println("我是时间代理类");
        System.out.println("汽车行驶开始......");
        long startTime = System.currentTimeMillis();
        moveApi.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束，用时:" + (endTime - startTime) + "毫秒");
    }
}
