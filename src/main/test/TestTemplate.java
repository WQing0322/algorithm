import com.wqing.demo.pattern.template.Coffee;
import com.wqing.demo.pattern.template.MakeDrink;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class TestTemplate {
    public static void main(String[] args) {
        MakeDrink coffee = new Coffee();
        coffee.makeDrinkMethod();
    }
}
