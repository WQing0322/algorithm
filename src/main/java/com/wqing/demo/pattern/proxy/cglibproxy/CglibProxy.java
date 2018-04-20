package com.wqing.demo.pattern.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    /**
     * 获取代理类
     *
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz) {
        //设置创建子类的类，为每个子类设置代理类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();//创建子类的实例并返回
    }

    /**
     * 拦截所有目标类方法的作用
     *
     * @param obj         目标类的实例
     * @param method      目标方法的反射对象
     * @param args        方法的参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        /**
         * 通过代理类调用父类的方法
         */
        System.out.println("我是cglib代理类");
        System.out.println("代理类日志打印开始....");
        methodProxy.invokeSuper(obj, args);
        System.out.println("代理类日志打印结束....");
        return null;
    }
}
