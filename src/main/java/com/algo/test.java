package com.algo;


import javax.script.ScriptEngineManager;
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

    }

    public static void mergeSort(int[] arr, int left, int right) {


    }


    public static void merge(int[] arr, int left, int right, int avg) {

     }

    public static int binarySearchRecursive(int[] arr, int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (key == arr[mid]) {
            return mid;
        }

        if (start >= end) {
            return -1;
        } else if (key < arr[mid]) {
            return binarySearchRecursive(arr, start, mid -1, key);
        } else if (key > arr[mid]) {
            return binarySearchRecursive(arr, mid + 1, end, key);
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
                start = mid +1;
            } else if (key < arr[mid]) {
                end = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
