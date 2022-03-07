package com.algo.sort;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

/**
 * 插入排序 (最重要的排序)
 * 打扑克牌原理
 * Created by dai on 2022/2/15
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int data = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > data){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j+1] = data;
//            System.out.println("第 "+ i + " 次的排序结果为：" );
//            for (j = 0; j < len; j++) {
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {9, 7, 4, 1, 10, 23, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println((System.currentTimeMillis() - start) );
    }

}
