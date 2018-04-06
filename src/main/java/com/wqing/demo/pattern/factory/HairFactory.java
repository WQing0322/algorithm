package com.wqing.demo.pattern.factory;

/**
 * Created by weiqing1 on 2018/4/6.
 * <p>
 * 发型工厂
 */
public class HairFactory {

    public HairApi getHair(String key){

        if("left".equals(key)){
            return new LeftHairApiImpl();
        }else if ("right".equals(key)){
            return new RightHairApiImpl();
        }else {
            return null;
        }
    }
}
