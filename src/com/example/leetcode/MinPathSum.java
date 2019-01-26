package com.example.leetcode;

/**
 * 最小路径和
 *
 * @author mengchen
 * @time 19-1-26 下午12:31
 */
public class MinPathSum {

    /**
     * 动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    } else {
                        dp[i][j] += dp[i - 1][j];
                    }
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

}
