package com.algo.tree;

import java.util.Arrays;

/**
 * 堆Tree 排序
 *
 * Created by dai on 2022/4/12
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 20, 7, 3, 1, 25, 14, 17};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] data) {
        int len = data.length;
        // 0(nlogn)
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }

        // 0(nlogn)
        for (int i = len -1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeap(data, 0, i);
        }
    }

    public static void maxHeap(int[] data, int start, int end) {
        int parent = start;
        // 下标是从0开始就要 + 1，从 1 就不用（+1）
        int son = parent * 2 + 1;
        while (son < end) {
            // temp 表示是我们左右节点大的那个
            int temp = son;
            // 比较左右节点和父节点的大小
            // 表示右节点比左节点大
            if (son + 1 < end && data[son] < data[son + 1]) {
                // 就要换右节点跟父节点
                temp = son + 1;
            }
            if (data[parent] > data[temp]) {
                // 不用交换
                return;
            } else {
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                parent = temp;
                // 继续堆化
                son  = parent * 2 + 1;
            }
        }
    }


}
