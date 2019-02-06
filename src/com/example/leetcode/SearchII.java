package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-6 下午5:25
 */
public class SearchII {
    public boolean search(int[] nums, int target) {
        int x = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                x = i + 1;
            }
        }
        int i = binarySearch(nums, 0, x -1, target);
        if (i > -1) {
            return true;
        }
        int i1 = binarySearch(nums, x, nums.length - 1, target);
        if (i1 > -1) {
            return true;
        }
        return false;
    }

    int binarySearch(int nums[], int start, int end, int target) {
        int middle;

        while (start <= end) {
            middle = (start + end) >>> 1;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target){
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchII().search(new int[]{3, 1, 1}, 3));
    }
}
