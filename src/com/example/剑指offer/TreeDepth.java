package com.example.剑指offer;

/**
 * 二叉树的深度
 * @author mengchen
 * @time 19-4-4 上午9:11
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }


}
