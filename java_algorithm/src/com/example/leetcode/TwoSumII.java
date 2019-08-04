package com.example.leetcode;

/**
 * 两数之和 II - 输入有序数组
 * @author mengchen
 * @time 19-3-4 下午1:58
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        return new int[] {1, 2};
    }
}
