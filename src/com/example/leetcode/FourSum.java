package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchen
 * @time 18-11-25 下午2:46
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                ArrayList<Integer> r1 = new ArrayList<>();
                r1.add(nums[0]);
                r1.add(nums[1]);
                r1.add(nums[2]);
                r1.add(nums[3]);
                result.add(r1);
            }
            return result;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int res = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (res == nums[start] + nums[end]) {
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[start]);
                        r.add(nums[end]);
                        result.add(r);
                        start++;
                        while (start < end && nums[start - 1] == nums[start]) {
                            start++;
                        }
                        end--;
                    } else if (nums[start] + nums[end] < res) {
                        start++;
                        while (start < end && nums[start - 1] == nums[start]) {
                            start++;
                        }
                    } else {
                        end--;
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
