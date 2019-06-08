package com.example.leetcode;

import java.util.Arrays;

/**
 * 不同路径 II
 * @author mengchen
 * @time 19-1-25 下午1:50
 */
public class UniquePathsWithObstacles {
    /**
     * 动态规划，以不同路径题目的答案为基础修改
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i], 0);
//        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    if (j - 1 >= 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        if (j == 0) {
                            continue;
                        }
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
}
