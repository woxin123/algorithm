package com.example.剑指offer;

/**
 * 平衡二叉树
 * @author mengchen
 * @time 19-4-4 上午9:16
 */
public class IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1
                && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
