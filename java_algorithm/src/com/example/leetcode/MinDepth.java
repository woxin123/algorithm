package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

/**
 * 二叉树的最小深度
 * @author mengchen
 * @time 19-2-10 下午2:42
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (right != 0 && left != 0) ? 1 + Math.min(left, right)
                : 1 + left + right;
    }
}
