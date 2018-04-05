import java.util.Random;

/**
 * Created by weiqing1 on 2018/4/3.
 */
public class BinaryChopDemo {

    //sourceArray 有序数组
    static int binaryChopFunc(int[] sourceArray, int target) {
        if (sourceArray == null || sourceArray.length <= 0) {
            return -1;
        }

        int l = 0, r = sourceArray.length - 1;//在[l.....r] 闭区间查找某个元素

        while (l <= r) {
            int mid = (l + r) / 2;//两个整数相加 可能会出现整形溢出的情况，所以可以改为：l + (r-l)/2
            if (target > sourceArray[mid]) {
                l = mid + 1;
            } else if (target == sourceArray[mid]) {
                return mid;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] sourceArray = new int[1000000];

        final int j = 1;
        for (int i = 0; i < 1000000; i++) {
//
//            Random random = new Random();
//            sourceArray[i] = j + (random.nextInt(10) + 1);
            sourceArray[i] = i;

        }

        System.out.println("startTime:" + System.currentTimeMillis());
        System.out.println("result:" + binaryChopFunc(sourceArray, 10100));
        System.out.println("endTime:" + System.currentTimeMillis());
    }
}
