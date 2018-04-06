package com.wqing.demo.pattern.template;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class Coffee extends MakeDrink {
    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }

    @Override
    protected boolean isAddCondiments() {
        return false;
    }
}
