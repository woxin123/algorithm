package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-31 下午3:52
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            dfsNQueue(result, queue, 0, i, n);
        }
        return result;
    }

    public void dfsNQueue(List<List<String>> strs, int[] queue, int layer, int index, int n) {
        queue[layer] = index;
        if (layer == n - 1) {
            layer++;
            List<String> item = new ArrayList<>();
            for (int i = 0; i < layer; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (queue[i] != j) {
                        s.append(".");
                    } else {
                        s.append("Q");
                    }
                }
                item.add(s.toString());
            }
            strs.add(item);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(queue, layer + 1, i)) {
                dfsNQueue(strs, queue, layer + 1, i, n);
            }
        }
    }

    private boolean isValid(int[] queue, int layer, int index) {
        for (int i = 0; i < layer; i++) {
            if (index == queue[i] || Math.abs(layer - i) == Math.abs(queue[i] - index)) {
                return false;
            }
        }
        return true;
    }


}
