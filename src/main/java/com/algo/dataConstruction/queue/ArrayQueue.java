package com.algo.dataConstruction.queue;

/**
 * 数组实现「单向」队列
 * Created by dai on 2022/1/5
 */
public class ArrayQueue {

    public static int[] data;
    public static int head = 0;
    public static int tail = 0;
    public static int size = 0;

    public ArrayQueue(int num) {
        this.data = new int[num];
        size = num;
    }


    /**
     * 新增元素
     */
    public static void push(int item) {
        if (isFull()) {
            return;
        }
        data[tail] = item;
        // 单向数组队列操作
        tail++;
    }

    /**
     * 是否已满
     * @return
     */
    public static boolean isFull() {
        return tail == size;
    }

    /**
     * 是否为空
     * @return
     */
    public static boolean isEmpty() {
        return tail == head;
    }

    /**
     * 获取元素
     * @return
     */
    public static int pop() {
        if (isEmpty()) {
            return 0;
        }
        int result = data[head];
        head++;
        return result;
    }

    public static void main(String[] args) {
        ArrayQueue singleArrayQueue = new ArrayQueue(5);
        for (int i = 1; i <= 5; i++) {
            push(i);
        }
        for (;;) {
            int n = pop();
            System.out.println(n);
            if (n == 0) {
                break;
            }
        }

    }

}
