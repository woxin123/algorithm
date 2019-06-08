package com.example.base.sort;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-20 上午11:09
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    flag = true;
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
            if (!flag) {
                dp[i] = -1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
    }

}
