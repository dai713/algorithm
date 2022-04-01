package com.algo.dataConstruction.queue;

/**
 * 数组实现「双向」队列
 * Created by dai on 2022/1/5
 */
public class ArrayDeque {

    public static int[] data;
    public static int head = 0;
    public static int tail = 0;
    public static int size = 0;

    public ArrayDeque(int num) {
        data = new int[num];
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
        // 双向数组队列操作
        tail = (tail + 1) % size;
    }

    /**
     * 是否已满
     * @return
     */
    public static boolean isFull() {
        // (tail + 1) % size  取模，保证计算的结果在数组大小范围之内
        return (tail + 1) % size == head;
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
        head = (head + 1) % size;
        return result;
    }

    public static void main(String[] args) {
        ArrayDeque singleArrayQueue = new ArrayDeque(8);
        for (int i = 1; i <= 8; i++) {
            push(i);
//            System.out.println(i % 5);
        }

    }

}
