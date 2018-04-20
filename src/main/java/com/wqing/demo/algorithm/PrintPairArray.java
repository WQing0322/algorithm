package com.wqing.demo.algorithm;

import java.util.Arrays;

/**
 * Created by weiqing1 on 2018/4/15.
 */
public class PrintPairArray {
    /**
     * 找到数组中两个元素相加等于指定数的所有组合
     * 元素数据无重复
     *
     */


    public void printPairArray(int arr[], int sum, int size) {
        int left = 0;
        int right = size - 1;
        int count = 0;
        Arrays.sort(arr);
        while (left < right) {
            int tempSum = arr[left] + arr[right];
            if (tempSum == sum) {
                System.out.println("满足条件组合：" + arr[left] + "," + arr[right]);
                count++;
                left++;
                right--;
            } else if (tempSum > sum) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println("一共满足条件的有" + count + "对");
    }

    public static void main(String[] args) {
        PrintPairArray printPairArray = new PrintPairArray();
        printPairArray.printPairArray(new int[]{2, 1, 2, 5, 3, 7, 3, 1, 5}, 6, 9);
    }
}
