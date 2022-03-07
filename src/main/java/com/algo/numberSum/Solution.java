package com.algo.numberSum;

/**
 *
 * Created by dai on 2022/1/8
 */
public class Solution {


    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for (int i =0; i < last.length; i++) {
            last[i] = -1;
        }

        int n = s.length();

        int start = 0, res = 0;
        for (int i =0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    /**
     * 寻找两个正序数组的中位数
     * 循环 + 双指针方法
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        int num1Index = 0, num2Index = 0;
        // 存放排序后的数组
        int[] result = new int[k];

        /**
         * 先排序，后计算
         */
        for (int i= 0; i < k; i++) {
            if (num1Index >= m) {
                // 第一个数组遍历完了，完全取第二个数组元素
                result[i] = nums2[num2Index++];
            } else if(num2Index >= n) {
                // 第二个数组遍历完了，完全取第一个数组元素
                result[i] = nums1[num1Index++];
            } else if(nums1[num1Index] < nums2[num2Index]) {
                // 第一个数组元素 < 第二个数组元素，取第一个数组元素
                result[i] = nums1[num1Index++];
            } else {
                result[i] = nums2[num2Index++];
            }
        }

        double resultVal;
        // 计算
        if (result.length % 2 == 0) {
            // 长度为偶数
            int firstIndex = (result.length / 2) - 1;
            int first = result[firstIndex];
            int seconds = result[firstIndex + 1];
            resultVal = (double)(first + seconds) / 2;
        } else {
            // 长度为基数
            resultVal = result[(result.length / 2)];
        }

        return resultVal;

    }



    /**
     * 合并两个数组，并升序排序
     * 循环 + 双指针方法 （只能适用于两个数组都是递增排列）
     * @param num1 第一个数组
     * @param m 第一个数组的长度
     * @param num2 第二个数组
     * @param n 第二个数组的长度
     *
     */
    public static  void merge(int[] num1, int m, int[] num2, int n) {
        // 两个数组总长度
        int k = m + n;
        // 存放排序后的结果
        int[] result = new int[k];
        // 第一个数组指针位置
        int num1Index = 0;
        // 第二个数组指针位置
        int num2Index = 0;

        // 循环 + 双指针
        for (int i = 0; i < k; i++) {
            if (num1Index >= m) {
                // 第一个数组已经取完了，完全取第二个数组即可
                result[i] =  num2[num2Index++];
            } else if(num2Index >= n) {
                // 第二个数组取完了，完全从第一个数组中取
                result[i] = num1[num1Index++];
            } else if(num1[num1Index] < num2[num2Index]) {
                // num1元素<num2元素，取第一个数组的值；
                result[i] = num1[num1Index++];
            } else {
                // num1元素>=num2元素，取第二个数组的值；
                result[i] = num2[num2Index++];
            }
        }
//
//        for (int i = 0; i < k; i++) {
//            num1[i] = result[i];
//        }

        System.out.println(result);

    }

    /**
     * 两个链表升序排序
     * 循环 + 双指针方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }

        // 返回合并以后的结果
        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            // 遍历一次后，拿到下一个node再进行插入
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return listNode.next;
    }




    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3,4};
//        merge(num1, num1.length, num2, num2.length);
//        System.out.println(findMedianSortArrays(num1, num2));
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
