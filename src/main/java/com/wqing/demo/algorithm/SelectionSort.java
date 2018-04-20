package com.wqing.demo.algorithm;

import java.util.Arrays;

/**
 * Created by weiqing1 on 2018/4/15.
 */
public class SelectionSort {
    /**
     * 选择排序
     *
     * @param arr
     * @param size
     */
    public void selectionSort(int arr[], int size) {

        for (int i = 0; i < size; i++) {

            //在[i,n)区间内找到最小的元素下标
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //并和i位置的元素交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int m = 0; m < size; m++) {
            System.out.print(arr[m] + " ,");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(new int[]{2, 4, 23, 8, 9, 56, 4}, 7);

    }
}
