package com.wqing.demo.designmode;

/**
 * Created by weiqing1 on 2018/4/5.
 */

/**
 * 单例模式：保证整个应用中某个实例只有一个
 * 应用场合：有些对象只需要一个就足够了，如皇帝，老婆。。。。
 * 类型：懒汉模式；饿汉模式；
 */
public class SingletonDemo {

    /**
     * 唯一实例在类加载时创建-----饿汉模式
     */

    //1.创建一个私有构造方法，不允许外部直接创建对象
    private SingletonDemo() {

    }

    //2.创建私有静态成员变量，创建类的唯一实例
    private static SingletonDemo instance = new SingletonDemo();

    //3.提供公有静态方法，获取实例
    public static SingletonDemo getInstance() {
        return instance;
    }

}
