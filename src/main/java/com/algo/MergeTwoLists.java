package com.algo;

import com.algo.numberSum.ListNode;

/**
 *  合并两个升序链表
 * Created by dai on 2022/1/17
 */
public class MergeTwoLists {

    public static ListNode head;
    public static ListNode head2;

    /**
     * 尾插法，单向链表
     * @param val
     * @return
     */
    public static void insertTail(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode cur = head;
        // 拿到最后一个节点（node）
        while (null != cur.next) {
            cur = cur.next;
        }

        // 现在一个节点，赋于最后一个node的next
        cur.next = new ListNode(val);

    }

    /**
     * 尾插法，单向链表
     * @param val
     * @return
     */
    public static void insertTail2(int val) {
        if (head2 == null) {
            head2 = new ListNode(val);
            return;
        }
        ListNode cur = head2;
        // 拿到最后一个节点（node）
        while (null != cur.next) {
            cur = cur.next;
        }

        // 现在一个节点，赋于最后一个node的next
        cur.next = new ListNode(val);

    }

    /**
     * 循环 + 双指针方式
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {

        // 定义一个头节点
        ListNode head = new ListNode(0);
        // 头节点的子节点
        ListNode cur = head;

        while (l1 != null && l2 != null) {
             if(l1.val < l2.val) {
                cur.next = l1;
                 cur = cur.next;
                 l1 = l1.next;
             } else {
                cur.next = l2;
                cur = cur.next;
                 l2 = l2.next;
             }
        }

        cur.next = l1 == null ? l2 : l1;

        return head.next;

    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            insertTail(i);
        }
        for (int i = 1; i < 3; i++) {
            insertTail2(i);
        }

       ListNode result =  mergeTwoList(head, head2);
        System.out.println(result);
    }

}
