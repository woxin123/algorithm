package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

/**
 * 求根到叶子节点数字之和 |求根到叶子节点数字之和|递归(dsf)|[SumNumbers](SumNumbers.java)|2019-02-16|
 * @author mengchen
 * @time 19-2-17 上午1:31
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelp(root, 0);
    }

    public int sumNumbersHelp(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        x += root.val;
        if (root.left == null && root.right == null) {
            return x;
        }
        return sumNumbersHelp(root.left, x * 10) + sumNumbersHelp(root.right, x * 10);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.stringToTreeNode("[1,2,3]");
        System.out.println(new SumNumbers().sumNumbers(treeNode));
    }
}
