package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-1-30 上午11:15
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineHelp(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void combineHelp(List<List<Integer>> res, ArrayList<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            res.add((List<Integer>) list.clone());
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            combineHelp(res, list, n, k, i + 1);
            list.remove(new Integer(i));
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
