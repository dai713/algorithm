package com.algo.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * Created by dai on 2022/2/17
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9,5,6,8,0,3,7,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right) {
        int base = arr[left];
        int ll = left;
        int rr = right;
        // 从后往前比对
        while (ll < rr) {
            while (ll < rr && arr[rr] >= base ) {
                rr--;
            }
            if (ll < rr) {
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                ll++;
            }
            // 从前往后比对
            while (ll < rr && arr[ll] <= base) {
                ll++;
            }
            if (ll < rr){
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                rr--;
            }
        }

        if (left < ll) {
            mergeSort(arr, left, ll - 1);
        }
        if (rr < right) {
            mergeSort(arr, ll + 1, right);
        }
    }
}
