package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到消失的数字
 * Created by dai on 2022/1/17
 */
public class FindDisappearedNum {

    public static List<Integer> findDisappeared(int[] nums) {
        int size = nums.length;
        for (int num : nums) {
            int x = (num - 1) % size;
            nums[x] += size;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (nums[i] <= size) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        findDisappeared(new int[]{1,2,3,4,5,4,5});
    }
}
