package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * @author mengchen
 * @time 19-4-26 下午2:33
 */
public class CombinationSum3 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Help(k, n, new ArrayList<>(), 0, 1);
        return res;
    }

    private void combinationSum3Help(int k, int n, List<Integer> list, int sum, int index) {
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }


        for (int i = index; i <= 9; i++) {
            list.add(i);
            sum += i;
            combinationSum3Help(k, n, list, sum, i + 1);
            sum -= i;
            if (list.size() != 0) {
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

}
