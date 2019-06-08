package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 回溯算法
 * @author mengchen
 * @time 19-1-3 下午9:45
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsd(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void subsetsd(List<List<Integer>> result, ArrayList<Integer> item, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            item.add(Integer.valueOf(nums[i]));
            subsetsd(result, (ArrayList<Integer>) item.clone(), nums, i + 1);
            item.remove(Integer.valueOf(nums[i]));
        }
        result.add((List<Integer>) item.clone());
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }
}
