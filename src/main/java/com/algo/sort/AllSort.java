package com.algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * Created by dai on 2022/1/20
 */
public class AllSort {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        backTrack(n, list, res, 0);
        return res;

    }

    public static void backTrack(int n, List<Integer> list, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(list));
        }

        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(list, first, i);
            // 继续递归天下一个数
            backTrack(n, list, res, first + 1);
            // 撤销操作
            Collections.swap(list, first, i);

        }
    }

    public static void main(String[] args) {

        permute(new int[]{1,2,3});
    }

}
