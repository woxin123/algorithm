package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-4-20 下午1:03
 */
public class NumSquares {
    static int[] dp = new int[100];

    static {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }
    }


    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 4) {
            return n;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(10));
    }

}
