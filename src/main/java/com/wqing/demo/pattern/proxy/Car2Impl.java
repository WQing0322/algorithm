package com.wqing.demo.pattern.proxy;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class Car2Impl extends CarImpl {

    @Override
    public void move() {
        System.out.println("我是Car3Impl");
        System.out.println("汽车行驶开始......");
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束，用时:" + (endTime - startTime) + "毫秒");
    }

}
