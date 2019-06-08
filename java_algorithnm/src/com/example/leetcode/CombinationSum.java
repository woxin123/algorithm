package com.example.leetcode;

import java.util.*;

/**
 * @author mengchen
 * @time 18-12-25 上午9:53
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        findcombinationSum1(res, list, candidates, target, 0);
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        findcombinationSum2(res, list, candidates, target, 0);
        return res;
    }

    private void findcombinationSum1(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int num) {
        if (target == 0) {
            res.add((List<Integer>) ((ArrayList)list).clone());
        }
        if (target < 0) {
            return;
        }

        for (int i = num; i < candidates.length; i++) {
            list.add(Integer.valueOf(candidates[i]));
            findcombinationSum1(res, list, candidates, target - candidates[i], i + 1);
            list.remove(Integer.valueOf(candidates[i]));
        }
    }

    private void findcombinationSum2(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int num) {
        if (target == 0) {
            res.add((List<Integer>) ((ArrayList)list).clone());
        }
        if (target < 0) {
            return;
        }

        for (int i = num; i < candidates.length; i++) {
            if (i > num && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(Integer.valueOf(candidates[i]));
            findcombinationSum2(res, list, candidates, target - candidates[i], i + 1);
            list.remove(Integer.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum1(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
        lists = combinationSum.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }

}
