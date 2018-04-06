package com.wqing.demo.pattern.singleton;

/**
 * Created by weiqing1 on 2018/4/5.
 */

/**
 * 单例模式---懒汉模式
 * <p>
 * 懒汉和饿汉模式的区别：
 * 懒汉--类加载时快，但是运行时获取对象的速度较慢，线程不安全
 * 饿汉--类加载时慢，但是运行时获取对象的速度较快，线程安全
 */
public class SingletonDemo2 {

    //1.将构造方法私有化，不允许外部直接创建对象
    private SingletonDemo2() {

    }

    //2.声明静态成员变量，此时不创建其实例
    private static SingletonDemo2 instance;

    //3.创建公有构造方法，创建类的唯一实例
    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}
