package com.algo.other;

/**
 * 斐波那契 fn = f(n-1) + f(n-2)
 * (递归 f(n) = f(n-1)+1)
 * Created by dai on 2022/1/6
 */
public class Fibonacci {

    public static int[] data = new int[20];

    /**
     * 斐波那契算法实现
     * 1，1，2，3，5，8，13，21，34......
     * fn = f(n-1) + f(n-2)
     * @return
     */
    public static int fibo(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }


    /**
     * 循环实现斐波那契数列
     * @param n
     * @return
     */
    public static int noFibo(int n) {
        if (n <= 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a+b;
            a = b;
            b = c;
        }

        return c;

    }

    /**
     * 数组做缓存，实现斐波那契数列
     * @param n
     * @return
     */
    public static int arrFibo(int n) {
        if (n <= 2) {
            return 1;
        }
        if (data[n] > 0) {
            return data[n];
        }
        // data[i] = data[n-1] + data[n-2]
        int res = arrFibo(n-1) + arrFibo(n-2);
        data[n] = res;
        return res;

    }

    /**
     * 尾递归
     * @param pre 上上一个结果值
     * @param res 上一个结果值
     * @param n
     * @return
     */
    public static int tailFibo(int pre, int res, int n ) {
        if (n <= 2) {
            return res;
        }
        return tailFibo(res, pre + res, n - 1);

    }

    /**
     * 递归算法实现 f(n) = f(n-1)+1
     * @param n
     * @return
     */
    public static int recursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return recursive(n-1)+1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + noFibo(i));
//            System.out.println(i + " - " + arrFibo(i));
//            System.out.println(i + " - " + tailFibo(1, 1, i));
        }
    }




}
