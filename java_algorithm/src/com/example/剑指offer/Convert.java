package com.example.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        ArrayList<TreeNode> pNode = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }   // 左子树入栈
            if (!stack.isEmpty()) {
                p = stack.pop();
                pNode.add(p);
                p = p.right;
            }

//            if (p.left != null) {
//                stack.push(p.left);
//            } else {
//                pNode.add(p);
//                if (p.right == null) {
//                    stack.pop();
//                } else {
//                }
//            }
        }
        TreeNode pre = null;
        for (int i = 0; i < pNode.size(); i++) {
            TreeNode node = pNode.get(i);
            node.left = pre;
            pre = node;
            if (i != pNode.size() - 1)
                node.right = pNode.get(i + 1);
            else
                node.right = null;
        }
        return pNode.get(0);
    }
}
