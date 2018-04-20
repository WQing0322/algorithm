package com.wqing.demo.pattern.proxy;

import java.util.Random;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class CarImpl implements MoveApi {

    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中....");
} catch (InterruptedException e) {
        e.printStackTrace();
        }

        }
        }
