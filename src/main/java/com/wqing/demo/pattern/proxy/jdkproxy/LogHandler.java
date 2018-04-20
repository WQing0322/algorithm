package com.wqing.demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class LogHandler implements InvocationHandler {
    private Object target;

    public LogHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是日志代理");
        System.out.println("日志打印开始......");
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("日志打印结束，用时:" + (endTime - startTime) + "毫秒");
        return null;
    }
}
