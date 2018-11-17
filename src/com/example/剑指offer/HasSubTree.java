package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-26
 */

/**
 *
 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return false;
        if (t2 == null)
            return true;
        if (t1.val != t2.val) {
            return false;
        }
        return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);
    }

}
