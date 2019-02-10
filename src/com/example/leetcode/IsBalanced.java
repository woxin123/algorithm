package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

/**
 * @author 孟晨
 * @date 2019/2/9 22:00
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(countTreeHeight(root.left) - countTreeHeight(root.right)) > 1) {
            return false;
        } else {
            if (isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            }
        }
        return false;
    }

    private int countTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(countTreeHeight(root.left), countTreeHeight(root.right));
    }
}
