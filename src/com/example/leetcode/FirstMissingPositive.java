package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-12-26 上午8:48
 */
public class FirstMissingPositive {


    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        int i = 1;
        Arrays.sort(nums);
        if (nums[0] > 1) {
            return 1;
        }
        if (nums[0] < 1 && nums[1] > 1) {
            return 1;
        }
        boolean flag = false;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                flag = true;
            }
            if (j == nums.length - 1) {
                if (!flag) {
                    return 1;
                }
                return nums[j] + 1;
            }

            if (nums[j] <= 0 || nums[j] == nums[j + 1]) {
                continue;
            }
            if (nums[j + 1] - nums[j] != 1) {
                if (!flag) {
                    return 1;
                }
                return nums[j] + 1;
            }

        }
        return i;
    }

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] < len) {
                if (nums[nums[i] - 1] == nums[i]) {
                    nums[i] = 0;
                    break;
                }
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        int index = 0;
        for (; index < len && nums[index] == index + 1; index++) {
            continue;
        }
        return index + 1;

    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();

        System.out.println(f.firstMissingPositive2(new int[]{16, -10, 14, 13, 8, 0, 13, -1, -9, 6, 0, -6, 15, 13, 6, 18, -2, 2, 7}));
    }

}
