package com.example.classic;

import java.util.Arrays;

/**
 * 01背包问题
 * <p>
 * 状态转移方程是：f[i, j] = Max{f[i - 1, k - Wi] + Pi(i >= Wi), f[i - 1, j]}
 * i 表示当前要放进背包的物品
 * j 表示背包的承重大小
 * Wi表示当前放进物品重量的大小
 * Pi表示当前物品的价值
 * 决策：把当前物品放入之后和不放那个大，如果放入之后价值大，那就放入，如果不放价值大，那就不放
 *
 * @author mengchen
 * @time 19-4-20 上午11:26
 */
public class Classic1 {

    public int get01PackageAnswer(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length + 1][bag + 1];

        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= bag; j++) {
                if (j < weight[i - 1]) {
                    // 如果当前物品不拿，那当前的dp[i][j]就是上一行的值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        for (int i = 0; i < weight.length + 1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[weight.length][bag];
    }

    public static void main(String[] args) {
        Classic1 classic1 = new Classic1();
        int maxValue = classic1.get01PackageAnswer(new int[]{2, 2, 6, 5, 4}, new int[]{6, 3, 5, 4, 6}, 10);
        System.out.println(maxValue);
    }

}
