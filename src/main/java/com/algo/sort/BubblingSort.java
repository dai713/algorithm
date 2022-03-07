package com.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * Created by dai on 2022/2/17
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = {9, 7, 4, 1, 10, 23, 2};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int count = 0;
         for (int i = 0; i < arr.length - 1; i++) {
             // 优化方案
             boolean flag = false;
             for (int j = 0; j < arr.length-1 - i; j++) {
                 System.out.println(count++);
                 if (arr[j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                     flag = true;
                 }
             }
             if (!flag) break;
         }

        System.out.println(Arrays.toString(arr));
    }
}
