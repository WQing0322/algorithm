import com.wqing.demo.pattern.design.SingletonDemo;

/**
 * Created by weiqing1 on 2018/4/5.
 */
public class TestSingleton {


    public static void main(String[] args) {
        SingletonDemo instance1= SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
        if(instance1 == instance2){
            System.out.println("instance1和instance2是同一个实例");
        }else{
            System.out.println("instance1和instance2不是同一个实例");
        }
    }
}
