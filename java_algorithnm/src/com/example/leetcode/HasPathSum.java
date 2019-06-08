package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

/**
 * @author mengchen
 * @time 19-2-10 下午2:51
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelp(root, 0, sum);
    }

    public boolean hasPathSumHelp(TreeNode root, int current, int sum) {
        if (root == null) {
            return false;
        }
        current += root.val;
        if (root.left == null && root.right == null) {
            if (current == sum) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSumHelp(root.left, current, sum) || hasPathSumHelp(root.right, current, sum);
    }
}
