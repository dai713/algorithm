package com.algo.numberSum;

/**
 * 计算链表 两数之和
 * Created by dai on 2022/1/8
 */
public class TwoNumberSum {

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
        cur.next = new ListNode(val);;

    }

    public static void insertHead2(int val) {
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
     * l1= [2,4,5] l2 = [7,4,3,4]
     *  245 + 7434 = 7679
     *  输出：[9,7,6,7]
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int[] num1 = new int[20];
        int[] num2 = new int[20];
        ListNode list1 = l1;
        ListNode list2 = l2;
        int count = 0;
        // 获取数据
        while (list1.next != null) {
            num1[count] = list1.val;
            list1 = list1.next;
            count++;
        }
        num1[count] = list1.val;

        count = 0;
        while (list2.next != null) {
            num2[count] = list2.val;
            list2 = list2.next;
            count++;
        }
        num2[count] = list2.val;

        // 将数组数据反转保存
        String totalNum1 = "";
        String totalNum2 = "";
        for (int i = num1.length - 1; i >= 0; i--) {
            if (num1[i] <= 0 ) {
                continue;
            }
            totalNum1 = totalNum1 + num1[i];
        }

        for (int i = num2.length - 1; i >= 0; i--) {
            if (num2[i] <= 0 ) {
                continue;
            }
            totalNum2 = totalNum2 + num2[i];
        }

        // 计算
        int n = Integer.parseInt(totalNum1) + Integer.parseInt(totalNum2);

        // 转换成字符串，准备反转
        String n2 = String.valueOf(n);

        char[] chars = n2.toCharArray();
        if (chars.length == 0) {
            return null;
        }

        ListNode result = null;

        // 数字反转
        for (int i = chars.length - 1; i >= 0; i--) {
            int v = Integer.parseInt(String.valueOf(chars[i]));
            if (result == null) {
                result = new ListNode(v);
                continue;
            }
            ListNode node = result;
            if (node.next == null) {
                node.next = new ListNode(v);
                continue;
            }
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(v);

        }

        return result;

    }


    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            insertTail(i);
        }

//        for (int i = 10; i > 5; i--) {
//            insertHead2(i);
//        }
//
//        ListNode result  = addTwoNumbers(head, head2);
//
//        ListNode node = result;
//        int count = 1;
//        while (node.next != null) {
//            node = node.next;
//            System.out.println(" 顺序为：" + count + "  -  "  + node.val);
//        }


    }



}
