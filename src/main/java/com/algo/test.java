package com.algo;


import java.util.Arrays;

/**
 * Created by dai on 2022/2/17
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {9,5,6,8,0,3,7,1};
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
//        mergeSort(arr, 0, arr.length - 1);
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearchRecursive(srcArray, 0, srcArray.length -1, 78));
        System.out.println(binarySearchFor(srcArray, 78));

    }

    public static void insertSort(int[] arr) {
        for (int n = arr.length / 2; n >= 1; n /= 2) {
            for (int i = n; i < arr.length; i++) {
                int j = i - n;
                int temp = arr[i];
                for (; j >= 0; j-=n) {
                    if (arr[j] > temp) {
                        arr[j + n] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + n] = temp;
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int base = arr[left];
        int ll= left;
        int rr = right;

        while (ll < rr) {
            while (ll < rr && arr[rr] > base) {
                rr--;
            }
            if (ll < rr) {
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                ll++;
            }

            while (ll < rr && arr[ll] < base) {
                ll++;
            }
            if (ll < rr) {
                int temp = arr[rr];
                arr[rr] = arr[ll];
                arr[ll] = temp;
                rr--;
            }

            if (left < ll) {
                mergeSort(arr, left, ll-1);
            }
            if (rr < right) {
                mergeSort(arr, ll +1, right);
            }
        }

    }


    public static void merge(int[] arr, int left, int right, int avg) {
        int[] temp = new int[arr.length];
        int point1 = left;
        int point2 = avg +1;
        int location = left;

        while (point1 <= avg && point2 <= right) {
            if (arr[point1] > arr[point2]) {
                temp[location++] = arr[point2++];
            } else {
                temp[location++] = arr[point1++];
            }
        }

        while (point1 <= avg) {
            temp[location++] = arr[point1++];
        }

        while (point2 <= right) {
            temp[location++] = arr[point2++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    public static int binarySearchRecursive(int[] arr, int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (key == arr[mid]) {
            return mid;
        }

        if (start >= end) {
            return -1;
        } else if (key > arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, end, key);
        } else if (key < arr[mid]) {
            return binarySearchRecursive(arr, start, mid-1, key);
        }
        return -1;
    }

    public static int binarySearchFor(int[] arr, int key) {
        int mid = arr.length / 2;
        if (key == arr[mid]) {
            return mid;
        }

        int start = 0;
        int end = arr.length -1;

        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
