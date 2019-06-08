package com.example.leetcode;

/**
 * 寻找旋转排序数组中的最小值 |寻找旋转排序数组中的最小值|二分查找|[FindMin](FindMin.java)|2019-02-27|
 * @author mengchen
 * @time 19-2-27 下午4:13
 */
public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{3, 1, 2}));
    }
}
