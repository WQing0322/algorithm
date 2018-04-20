import com.wqing.demo.pattern.proxy.MoveApi;
import com.wqing.demo.pattern.proxy.myjdkproxy.Proxy;

/**
 * Created by weiqing1 on 2018/4/20.
 */
public class TestMyProxy {

    public static void main(String[] args) throws Exception {
        MoveApi moveApi = (MoveApi) Proxy.newProxyInstance(MoveApi.class);
        moveApi.move();
    }
}
