package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author mengchen
 * @time 19-2-13 上午11:33
 */
public class GetRow {
    private static List<List<Integer>> res = new ArrayList<>();

    static {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        res.add(list);
        List<Integer> pre = null;
        for (int i = 2; i < 33; i++) {
            list = new ArrayList<>();
            pre = res.get(i - 1);
            list.add(1);

            for (int j = 1; j < pre.size(); j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            list.add(1);
            res.add(list);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(3));
    }
}
