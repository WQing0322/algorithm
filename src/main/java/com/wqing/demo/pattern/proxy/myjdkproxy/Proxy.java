package com.wqing.demo.pattern.proxy.myjdkproxy;

import com.wqing.demo.pattern.proxy.Car;
import com.wqing.demo.pattern.proxy.CarImpl;
import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by weiqing1 on 2018/4/20.
 * 自定义编码 模拟实现jdk动态代理
 * <p>
 * 1）声明一段代码源码(动态代理生成)
 * 2）编译源码（JDK Compiler Api）,产生新的类（代理类）：一般是先生成一个java文件，然后对这个java文件进行编译
 * 3）将这类load到内存中，产生一个新的对象（代理对象）
 * 4）return 代理对象
 */
public class Proxy {

    public static Object newProxyInstance(Class interf) throws Exception {
        String rt = "\t\n";
        String methodStr = "";
        for (Method method : interf.getMethods()) {
            methodStr +=
                    "            @Override" + rt +
                            "           public void " + method.getName() + "() {" + rt +
                            "              System.out.println(\" 我是时间代理类 \");" + rt +
                            "             System.out.println(\" 汽车行驶开始......\");" + rt +
                            "           long startTime = System.currentTimeMillis();" + rt +
                            "           inter." + method.getName() + "();" + rt +
                            "          long endTime = System.currentTimeMillis();" + rt +
                            "         System.out.println(\" 汽车行驶结束，用时:\"" + rt +
                            " + (endTime - startTime) + \" 毫秒 \");" + rt +
                            "     }";
        }


        String str =
                "package com.wqing.demo.pattern.proxy.myjdkproxy;" + rt +
                        "public class $Proxy0 implements " + interf.getName() + " {" + rt +
                        "   private " + interf.getName() + " inter;" + rt +
                        "public $Proxy0(" + interf.getName() + " inter) {" + rt +
                        "       super();" + rt +
                        "      this.inter = inter;" + rt +
                        " }" + rt +
                        methodStr + rt +
                        "}";

        //1.产生代理类的java文件
//        System.getProperty("user.dir");//当前应用路径
//        String fileName = System.getProperty("user.dir") + "/src/main/com/wqing/demo/pattern/proxy/myjdkproxy/$Proxy0.java";
        String fileName = "D:\\JDJRFinance\\idea-workspaces\\algorithm\\algorithm\\target\\classes\\com\\wqing\\demo\\pattern\\proxy\\myjdkproxy\\$Proxy0.java";
        System.out.println(fileName);
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);

        //2.编译，得到当前系统的编译器
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, null, null);//创建文件管理者
        //获取文件
        Iterable units = standardJavaFileManager.getJavaFileObjects(fileName);
        //编译任务
        JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, units);
        //进行编译
        compilationTask.call();
        standardJavaFileManager.close();

        //将文件load到内存中
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class aClass = classLoader.loadClass("com.wqing.demo.pattern.proxy.myjdkproxy.$Proxy0");
        System.out.println(aClass.getName());

        //创建实例
        Constructor constructor = aClass.getConstructor(interf);
        return constructor.newInstance(new CarImpl());

    }
}
