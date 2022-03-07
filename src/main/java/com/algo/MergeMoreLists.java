package com.algo;

import com.algo.numberSum.ListNode;

/**
 * 合并 n 个排序链表
 * Created by dai on 2022/1/18
 */
public class MergeMoreLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        // 新建一个ListNode, 用于和数组中每个listNode 对比排序
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeList(result, lists[i]);
        }

        return result;

    }

    /**
     * 合并两个链表
     * 循环 + 双指针 方式
     * @param l1
     * @param l2
     * @return ListNode
     */
    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return null;
        if (l2 == null) return null;

        ListNode resNode = new ListNode(0);
        ListNode cur = resNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        cur.next = l1 == null ? l1 : l2;

        return resNode.next;
    }
}
