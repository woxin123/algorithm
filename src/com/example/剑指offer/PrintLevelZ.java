package com.example.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author mengchen
 * @time 19-4-19 下午2:52
 */
public class PrintLevelZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Stack[] stacks = new Stack[2];
        int current = 0;
        int next = 1;
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        stacks[current].push(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stacks[current].isEmpty()) {
            TreeNode pNode = (TreeNode) stacks[current].pop();
            list.add(pNode.val);
            if (current == 0) {
                if (pNode.left != null) {
                    stacks[next].push(pNode.left);
                }
                if (pNode.right != null) {
                    stacks[next].push(pNode.right);
                }
            } else {
                if (pNode.right != null) {
                    stacks[next].push(pNode.right);
                }
                if (pNode.left != null) {
                    stacks[next].push(pNode.left);
                }
            }

            if (stacks[current].isEmpty()) {
                current = 1 - current;
                next = 1 - next;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
