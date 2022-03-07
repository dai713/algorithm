package com.algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 * Created by dai on 2022/1/19
 */
public class LongerValidParentheses {

    /**
     * 使用 栈 原理实现
     *
     * @param s
     * @return
     */
    public static int longerValid(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "(((()";
//        System.out.println(longerValid(s));
        System.out.println(7/2);
    }
}
