package com.example.leetcode;

import com.example.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-7 下午9:55
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List[][] dp = new List[n + 2][n + 2];
        return generateTreesHelp(1, n, dp);
    }

    public List<TreeNode> generateTreesHelp(int start, int end, List[][] dp) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = dp[start][i - 1];
            if (lefts == null) {
                lefts = generateTreesHelp(start, i - 1, dp);
                dp[start][i - 1] = lefts;
            }
            List<TreeNode> rights = dp[i + 1][end];
            if (rights == null) {
                rights = generateTreesHelp(i + 1, end, dp);
                dp[i + 1][end] = rights;
            }
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
