package com.algo;

/**
 * 移动零
 * Created by dai on 2022/1/14
 */
public class MoveZero {

    /**
     * 给定一个数组nums，编写一个函数将所有0移动到数组到末尾，同时保持非零元素到相对顺序
     *  示例： [1，0，0，3，0，7]
     *  循环 + 双指针(数组必须是升序，否则还需要重新排序)
     * @param num
     */
    public static void  solution(int[] num) {

        // 记录 0 出现的次数
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                num[j++] = num[i];
            }
        }

        for (int i = j; i < num.length; i++) {
            num[i] = 0;
        }
        System.out.println(num);



    }

    public static void main(String[] args) {
//        solution(new int[]{1,0,0,3,0,7});
        String s = "234";
        char[] num = s.toCharArray();
        System.out.println(num[0]);
    }
}
