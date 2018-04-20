import com.wqing.demo.pattern.proxy.*;
import com.wqing.demo.pattern.proxy.cglibproxy.CglibProxy;
import com.wqing.demo.pattern.proxy.cglibproxy.Train;
import com.wqing.demo.pattern.proxy.jdkproxy.LogHandler;
import com.wqing.demo.pattern.proxy.jdkproxy.TimeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class TestProxy {

    public static void main(String[] args) {

        //Car2继承方式完成静态代理
//        MoveApi moveApi = new Car2Impl();
//        moveApi.move();

        //Car3聚合方式实现静态代理
//        CarImpl car = new CarImpl();
//        Car3Impl car3 = new Car3Impl(car);
//        car3.move();

//        MoveApi car = new CarImpl();
//        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
//        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
//        carLogProxy.move();

        //JDK动态代理测试
        CarImpl car = new CarImpl();
        InvocationHandler handler = new TimeHandler(car);
        MoveApi moveApi = (MoveApi) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), handler);
        moveApi.move();
//
//        InvocationHandler handler1 = new LogHandler(moveApi);
//        MoveApi moveApi1 = (MoveApi) Proxy.newProxyInstance(moveApi.getClass().getClassLoader(), moveApi.getClass().getInterfaces(), handler1);
//        moveApi1.move();

//        Car car = new Car();
//        InvocationHandler handler = new TimeHandler(car);
//        Car carProxy = (Car) Proxy.newProxyInstance(car.getClass().getClassLoader(),car.getClass().getInterfaces(),handler);
//        carProxy.move();


        //cglib动态代理类测试
//        CglibProxy cglibProxy = new CglibProxy();
//        Train train = (Train) cglibProxy.getProxy(Train.class);
//        train.move();

    }
}
