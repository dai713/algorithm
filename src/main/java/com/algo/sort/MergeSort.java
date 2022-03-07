package com.algo.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 *
 * Created by dai on 2022/2/15
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     * @param left 左边的第一个数的位置
     * @param right 右边的第一个数的位置
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 只有一个数据则跳过
        if (left >= right) {
            return;
        }

        // 二分法
        int mid = (left + right) / 2;
        // 先 "（递）归"
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 后"（和）并" 结果
        merge(arr, left, right, mid);

    }


    private static void merge(int[] arr, int left, int right, int mid) {
        // 新建一个临时数组存放 "并" 后的结果集
        int[] temp = new int[arr.length];

        // 第一个元素位置
        int point1 = left;
        // 最右边元素位置
        int point2 = mid + 1;

        // 临时数组当前移动至哪里
        int location = left;

        while(point1 <= mid && point2 <= right) {
            if (arr[point1] < arr[point2]) {
                temp[location] = arr[point1];
                location++;
                point1++;
            } else {
                temp[location] = arr[point2];
                location++;
                point2++;
            }
        }

        // 将数组为最后未排序的元素移动到临时数据
        while(point1 <= mid) {
            temp[location++] = arr[point1++];
        }

        while(point2 <= right) {
            temp[location++] = arr[point2++];
        }

        // 临时数据移动到结果数据中
        for(int i = left; i <= right; i++ ) {
            arr[i] = temp[i];
        }

    }


    public static void main(String[] args) {
        int[] arr = {9,5,6,8,0,3,7,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
