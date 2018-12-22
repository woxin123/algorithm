package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-21 下午8:12
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int start = 0,
                end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[start] < target ? start + 1 : start;
    }

}
