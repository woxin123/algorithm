package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @auther 孟晨
 * @date 2018/12/6 16:40
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums, lists, 0);
        return lists;
    }

    private void dfs(int[] nums, List<List<Integer>> lists, int j) {
        if (j == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(nums, lists, j + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
