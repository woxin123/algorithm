package com.example.leetcode;

/**
 * 乘积最大子序列
 * @author mengchen
 * @time 19-2-26 下午4:04
 */
public class MaxProduct {


    /**
     * 动态规划
     * 记录最大值和最小值，当出现负数的时候，那么最大值和最小值交换
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[] {2, 3, -2, 4}));
    }
}
