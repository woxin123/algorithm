package com.example.leetcode;

/**
 * @auther 孟晨
 * @date 2018/7/7 11:56
 */

/**
 * Given a binary tree, find its maximum depth.
 * 给一个二叉树，找出这个树的最大深度
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + ((left > right) ? left : right);
    }
}
