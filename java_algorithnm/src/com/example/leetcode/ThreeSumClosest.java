package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-11-23 下午5:40
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        if (nums.length == 3) {
            return res;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - temp) < Math.abs(target - res)) {
                    res = temp;
                }
                if (temp < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();

        System.out.println(closest.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
    }
}
