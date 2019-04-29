package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

/**
 * 翻转二叉树
 * @author mengchen
 * @time 19-4-29 上午11:52
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
