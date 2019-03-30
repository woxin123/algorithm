package com.example.leetcode;

/**
 * 长度最小的子数组
 * @author mengchen
 * @time 19-3-30 下午1:00
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0, sum = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= s) {
                res = res < j - i + 1 && res != 0 ? res : j - i + 1;
                sum -= nums[i];
                sum -= nums[j];
                i++;
                j--;
            }
        }
        return res;
    }

}
