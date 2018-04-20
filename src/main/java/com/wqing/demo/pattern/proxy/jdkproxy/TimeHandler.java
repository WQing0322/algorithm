package com.wqing.demo.pattern.proxy.jdkproxy;

import com.wqing.demo.pattern.proxy.MoveApi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class TimeHandler implements InvocationHandler {
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  被代理对象
     * @param method 被代理对象方法
     * @param args   被代理对象方法的入参
     * @return 返回的是方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是时间代理类");
        System.out.println("汽车行驶开始......");
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车行驶结束，用时:" + (endTime - startTime) + "毫秒");
        return null;
    }
}
