package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * @author mengchen
 * @time 19-3-15 下午9:02
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        res.add(root.val);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            if (!queue2.isEmpty()) {
                res.add(queue2.getLast().val);
            } else {
                return res;
            }
            LinkedList<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            queue2.clear();
        }
        return res;
    }
}
