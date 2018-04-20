import com.wqing.demo.pattern.template.Coffee;
import com.wqing.demo.pattern.template.MakeDrink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by weiqing1 on 2018/4/6.
 */
public class TestTemplate {
    public static void main(String[] args) {
//        MakeDrink coffee = new Coffee();
//        coffee.makeDrinkMethod();
//
//
//
//        List list = new ArrayList();
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            String s = (String) iterator.next();
//            if("a".equals(s)){
//                iterator.remove();
//            }
//        }


        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = str2.intern();
        String str4 = str1.intern();
        System.out.println("----" + (str3 == str4));
    }
}
