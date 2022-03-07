package com.algo.sort;

import javax.crypto.spec.PSource;
import java.util.Arrays;

/**
 * 希尔排序 （插入排序的改进版）
 *
 * Created by dai on 2022/2/17
 */
public class HillSort {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = {9,5,6,8,0,3,7,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println((System.currentTimeMillis() - start));

    }


    public static void sort(int[]arr) {

        for (int n = arr.length / 2; n >= 1; n = n / 2) {
            for (int i = n; i < arr.length; i++) {
                int data = arr[i];
                int j = i - n;
                for (; j >= 0; j -= n) {
                    if (arr[j] > data) {
                        arr[j + n] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + n] = data;
            }

        }
    }
}
