package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

import java.util.*;

/**
 * @author mengchen
 * @time 18-12-10 下午10:58
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                l.add(p.val);
                if (p.left != null) {
                    queue2.offer(p.left);
                }
                if (p.right != null) {
                    queue2.offer(p.right);
                }
            }
            LinkedList temp = queue;
            queue = queue2;
            queue2 = temp;
            if (flag) {
                list.add(l);
            } else {
                Collections.reverse(l);
                list.add(l);
            }
            flag = !flag;
        }
        return list;
    }

}
