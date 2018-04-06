package com.wqing.demo.pattern.template;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public abstract class MakeDrink {

    public final void makeDrinkMethod() {
        //1.将水煮沸
        boilWater();
        //2.泡制饮料 -- 需要子类定制化实现
        brew();
        //3.将饮料倒入杯中
        pourInCup();
        //4.加入调味料 -- 需要子类定制化实现
        if (isAddCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("将水煮沸");
    }

    /**
     * 定义为protected  是不允许子类调用其方法
     */
    protected abstract void brew();

    private void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void addCondiments();

    protected boolean isAddCondiments() {
        return true;
    }
}
