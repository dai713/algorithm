package com.algo.dataConstruction;

import com.algo.module.Node;

/**
 * 约瑟夫问题
 * Created by dai on 2021/12/29
 */
public class JosephusProblem {

    public static Node head;
    public static Node tail;
    public static Node prev;

    /**
     * 单链表，头插法
     */
    public static  void insertHead(int num) {
        Node newNode = new Node(num);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 循环链表,头插法
     */
    public static void insertLoop(int num) {
        Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
         newNode.next = head;
         head = newNode;
        }
        tail.next = head;
    }

    /**
     * 循环链表，尾插法
     */
    public static void insertTail(int num) {
        Node newNode = new Node(num);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head;
    }

    public static void main(String[] args) {

        /** 问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个 */

        // 人数
        int num = 5;
        // 数到m到人出圈
        int m = 3;
        // 第k个人开始报数
        int k = 1;

        for (int i = 0; i < num; i++) {
            insertTail(i);
        }

        Node h = head;
        Node before = null;
        int count = 0;
        while (h != h.next){
            count++;
            if (m == count) {
                before.next = h.next;
                count = 0;
                System.out.println(h.num +",");
                h = h.next;
            } else {
                before = h;
                h = h.next;
            }
        }

        System.out.println("最后是：" + h.num);


    }
}
