package com.algo.tree;

/**
 * 二叉搜索树
 *
 * Created by dai on 2022/3/1
 */
public class BinarySearchTree {
    public int val;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree(int val, BinarySearchTree left, BinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BinarySearchTree(int val) {
        this.val = val;
    }

    /**
     * 插入
     *
     * @param root
     * @param data
     */
    public static void insert(BinarySearchTree root, int data) {
        if (root == null) return;

        if (root.val < data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new BinarySearchTree(data);
            }
        } else {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new BinarySearchTree(data);
            }
        }
    }

    /**
     * 查找
     *
     * @param root
     * @param data
     */
    public static void find(BinarySearchTree root, int data) {
        if (root == null) return;

        if (root.val < data) {
            // 容错处理
            if (root.right != null) {
                find(root.right, data);
            } else {
                System.out.println("not found!");
            }
        } else if(root.val > data) {
            // 容错处理
            if (root.left != null) {
                find(root.left, data);
            } else{
                System.out.println("not found!");
            }
        } else {
            System.out.println("found it : " + root.val);
            return;
        }
    }

}
