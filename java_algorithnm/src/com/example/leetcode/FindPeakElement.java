package com.example.leetcode;

/**
 * 寻找峰值
 * @author mengchen
 * @time 19-3-1 下午2:25
 */
public class FindPeakElement {
    class Solution1 {
        /**
         * 暴力O(n)
         *
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    right = Integer.MIN_VALUE;
                } else {
                    right = nums[i + 1];
                }
                while (left < nums[i] && right < nums[i]) {
                    return i;
                }
                left = nums[i];
            }
            return 0;
        }
    }

    class Solution2 {
        /**
         * 二分法
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (mid > left && mid < right) {
                    if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                        return mid;
                    }

                }
                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }


}
