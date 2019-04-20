package com.example.剑指offer;

/**
 * @author mengchen
 * @time 19-4-19 下午5:00
 */
public class KthNode {

    private int k;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        this.k = k;
        return kthNodeCore(pRoot);
    }

    TreeNode kthNodeCore(TreeNode pRoot) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }

        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right);
        }

        return target;
    }

}
