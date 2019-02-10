package com.example.leetcode;

import com.example.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 * @author mengchen
 * @time 19-2-10 下午2:57
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSumHelp(root, sum, res, new ArrayList<>());
        return res;
    }

    private void pathSumHelp(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }
        pathSumHelp(root.left, sum - root.val, res, list);
        pathSumHelp(root.right, sum - root.val, res, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new PathSum().pathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }
}
