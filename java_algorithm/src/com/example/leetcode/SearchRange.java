package com.example.leetcode;

import java.util.Arrays;

/**
 * Find First and Last Psoition of Element in Sorted Array
 *
 * @author mengchen
 * @time 18-12-19 上午10:47
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 二分查找
        while (l <= r) {
            int m = (r + l) >>> 1;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                // 找到了
                int first = m, last = m;
                while (first > -1 && nums[first] == nums[m]) {
                    first--;
                }
                first++;
                while (last < nums.length && nums[last] == nums[m]) {
                    last++;
                }
                last--;
                return new int[]{first, last};

            }
        }
        return new int[]{-1, -1};

    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{5,7,7,8,8,10}, 6);
    }
}
