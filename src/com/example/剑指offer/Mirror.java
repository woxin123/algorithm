package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-27
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
