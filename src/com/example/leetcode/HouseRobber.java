package com.example.leetcode;

/**
 * 打家劫舍
 * @author mengchen
 * @time 19-3-14 上午9:28
 */
public class HouseRobber {
    /**
     * 动态规划
     */
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }

            return dp[n - 1];
        }
    }
}
