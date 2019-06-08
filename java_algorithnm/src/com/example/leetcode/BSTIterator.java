package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

import java.util.*;

/**
 * 二叉搜索树迭代器
 * @author mengchen
 * @time 19-3-6 上午9:29
 */
public class BSTIterator {

    class BSTIterator1 {

        private LinkedList<Integer> stack = new LinkedList<>();

        public BSTIterator1(TreeNode root) {
            inorder(root);
        }

        /**
         * 递归遍历
         * @param root
         */
        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            stack.push(root.val);
            inorder(root.right);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int res = stack.getLast();
            stack.removeLast();
            return res;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class BSTIterator2 {
        private List<Integer> list = new ArrayList<>();
        private Iterator<Integer> integerIterator;

        public BSTIterator2(TreeNode root) {
            inorder(root);
            this.integerIterator = list.iterator();
        }

        /**
         * 非递归遍历
         * @param root
         */
        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                if (!stack.isEmpty()) {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }

        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return integerIterator.next();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return integerIterator.hasNext();
        }
    }
}
