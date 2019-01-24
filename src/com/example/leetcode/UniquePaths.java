package com.example.leetcode;

import java.util.Arrays;

/**
 * 不同路径
 * @author mengchen
 * @time 19-1-24 上午11:39
 */
public class UniquePaths {



    /**
     * 使用dfs 超时了 dsf是下下之选
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return dfs(1, 1, m, n);
    }

    private int dfs(int x, int y, int m, int n) {
        if (x > m || y > n) {
            return 0;
        }
        int count1 = dfs(x + 1, y, m, n);
        int count2 = dfs(x, y + 1, m, n);
        if (x == m && y == n) {
            return 1 + count1 + count2;
        } else {
            return count1 + count2;
        }
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths2(51, 9));
    }
}
