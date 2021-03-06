package com.example.剑指offer;

import java.util.Arrays;

/**
 * @author: mengchen
 * Create by 18-4-21
 */


// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ReConstructBinaryTree {

    public static void main(String[] args) {

    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return treeNode;
    }
}
