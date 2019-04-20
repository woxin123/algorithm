package com.example.剑指offer;

import com.example.base.queue.LinkedQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mengchen
 * @time 19-4-19 下午2:28
 */
public class PrintTree {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int nextLevel = 0;
        int toBePrinted = 1;
        queue.push(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            list.add(node.val);
            --toBePrinted;
            if (toBePrinted == 0) {
                result.add(list);
                list = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }

}
