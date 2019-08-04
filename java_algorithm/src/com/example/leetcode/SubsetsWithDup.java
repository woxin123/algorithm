package com.example.leetcode;

import java.util.*;

/**
 * 子集 II
 * @author mengchen
 * @time 19-2-3 下午9:16
 */
public class SubsetsWithDup {

    // 1 1 1 2 2 2 3 4
    // 1 1 1 2 2 2 3 4
    // 1 1 2 2 2 3 4
    // 1 2 2 2 3 4
    // 2 2 2 3 4
    // 2 2 3 4
    // 2 3 4
    // 3
    // 4
    //
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelp(res, new ArrayList<>(), 0, nums);
//        for (List<Integer> l : set) {
//            res.add(l);
//        }
        res.add(new ArrayList<>());
        return res;
    }

    private void subsetsWithDupHelp(List<List<Integer>> res, ArrayList<Integer> list, int index, int[] nums) {
        if (index > nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            res.add((List<Integer>) list.clone());
            subsetsWithDupHelp(res, list, i + 1, nums);
            list.remove(list.size() - 1);
            // 过滤掉相同的元素，因为在递归中已经将这里算过了
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(new int[]{1, 1, 2, 2}));
    }
}
