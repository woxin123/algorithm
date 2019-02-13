package com.example.leetcode;

import java.util.List;

/**
 * 三角形路径总和
 * @author mengchen
 * @time 19-2-13 上午11:44
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list1 = triangle.get(i);
            List<Integer> list2 = triangle.get(i + 1);
            for (int j = 0; j < list1.size(); j++) {
                list1.set(j, list1.get(j) + Math.min(list2.get(j), list2.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
