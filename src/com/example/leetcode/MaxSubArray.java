package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-1-1 下午10:30
 */
public class MaxSubArray {

    /**
     * 动态规划  sum[i] = max(sum[i] + a[i], a[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE, tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (tmp > max) {
                max = tmp;
            }
            if (tmp < 0) {
                tmp = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, -1}));
    }

}
