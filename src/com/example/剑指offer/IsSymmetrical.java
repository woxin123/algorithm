package com.example.剑指offer;

/**
 * 对称的二叉树
 * @author mengchen
 * @time 19-4-18 下午10:03
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

}
