package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加括号
 * Created by dai on 2022/1/18
 */
public class GenParenthesis {

    /**
     * 递归算法
     * @param n 括号的数量
     * @return
     */
    public static List<String> genPare(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, new StringBuilder(), 0,0, n);
        return list;
    }

    /**
     *
     * @param ans 保存括号
     * @param cur 生成的括号
     * @param open 左边括号
     * @param close 右边括号
     * @param max 括号数量
     */
    public static void backTrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        // 判断括号的数量是否达到规定的数量
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // 左边括号的数量小于规定的数量，则继续新增
        if (open < max) {
            cur.append("(");
            // 递归生成规定的括号数量
            backTrack(ans, cur, open + 1, close, max);
            // 放入list后，删除最后面的括号
            cur.deleteCharAt(cur.length() - 1);
        }

        // 右边括号的数量小于规定的数量，则继续新增
        if (close < open) {
            cur.append(")");
            backTrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);

        }
    }

    public static void main(String[] args) {
        genPare(3);
    }
}
