package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchen
 * @time 18-11-22 下午5:00
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int  resever, start, end;

        for (int i = 0; i < nums.length - 2; i++) {
            resever = -nums[i];
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == resever) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    result.add(tmp);
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                    end--;
                } else if (nums[start] + nums[end] < resever) {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                } else {
                    end--;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
