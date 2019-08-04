package com.example.剑指offer;

import com.example.剑指offer.util.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * @author mengchen
 * @time 19-4-18 上午8:41
 */
public class GetNext {

    /**
     * 这道题的目的是为了返回二叉树的下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) {
                return parent;
            }
            pNode = pNode.next;
        }
        return null;
    }



}
