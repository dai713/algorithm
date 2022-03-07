package com.algo.tree;

import com.algo.module.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 二叉树前置遍历
 * Created by dai on 2022/2/10
 */
public class BinaryTree {

    /**
     * 二叉树前序遍历的顺序：root -> 左 -> 右
     * @param root
     * @return
     */
    public static ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 将根节点保存在栈中
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            // 获取栈中node
            TreeNode curr = stack.pop();
            res.add(curr.val);

            // stack是FILO，所以保存在stack中时要将右子节点先插入到stack中
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }

        }

        return res;
    }


    /**
     * 二叉树中序遍历：左 -> root -> 右
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> centerOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode leftNode = stack.pop();
            res.add(leftNode.val);

            cur = leftNode.right;
        }

        return res;

    }

    /**
     * 递归 - 前置遍历
     * root -> 左 -> 右
     * @param root
     */
    public static void pre(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) {
            pre(root.left);
        }

        if (root.right != null) {
            pre(root.right);
        }
    }

    /**
     * 递归 - 中置遍历
     *  左 -> root -> 右
     * @param root
     */
    public static void center(TreeNode root) {
        if (root.left != null) {
            center(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            center(root.right);
        }
    }

    /**
     * 递归 - 后置遍历
     *  左 -> 右 -> root
     * @param root
     */
    public static void post(TreeNode root) {
        if (root.left != null) {
            post(root.left);
        }
        if (root.right != null) {
            post(root.right);
        }
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(87);
        TreeNode node4 = new TreeNode(65);
        TreeNode node5 = new TreeNode(566);
        TreeNode node6 = new TreeNode(44);
        TreeNode node7 = new TreeNode(75);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;

//        System.out.println(preOrder(root));
//        System.out.println(centerOrder(root));
//        pre(root);
        center(root);



    }

}
