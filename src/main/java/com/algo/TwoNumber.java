package com.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * Created by dai on 2022/1/7
 */
public class TwoNumber {


//    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//    你可以按任意顺序返回答案。

    public static int[] calulate(int[] nums, int target) {
        int num;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            num = target - nums[i];
            map.put(nums[i], nums[i]);
            if (map.containsKey(num)) {
                result[0] = map.get(num);
                result[1] = nums[i];
                return result;
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7,11,15};
        int target = 9;
        int[] result = calulate(arr, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

}
