import com.wqing.demo.pattern.factory.HairApi;
import com.wqing.demo.pattern.factory.HairFactory;
import com.wqing.demo.pattern.factory.LeftHairApiImpl;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class TestFactory {

    public static void main(String[] args) {
        HairApi hair = new LeftHairApiImpl();
        hair.drawHair();;

        HairFactory hairFactory = new HairFactory();
        hairFactory.getHair("left").drawHair();
    }

}

