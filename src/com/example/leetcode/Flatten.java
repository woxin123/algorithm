package com.example.leetcode;

import com.example.leetcode.util.ListNode;
import com.example.leetcode.util.TreeNode;

/**
 * @author mengchen
 * @time 19-2-11 下午3:47
 */
public class Flatten {

    public void flatten(TreeNode root) {
        flattenHelp(root);
    }

    private TreeNode flattenHelp(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.right = left;
            root.left = null;
            root = flattenHelp(root.right);
        }
        if (right != null) {
            root.right = right;
            root.left = null;
            root = flattenHelp(root.right);
        }

        return root;
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        flatten.flatten(TreeNode.stringToTreeNode("[1,2,5,3,4,null,6]"));
    }
}
