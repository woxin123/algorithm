package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * @author mengchen
 * @time 19-2-13 上午11:21
 */
public class Generate {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1) {
            return res;
        }
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        res.add(list);
        if (numRows == 2) {
            return res;
        }
        List<Integer> pre = null;
        for (int i = 2; i < numRows; i++) {
            list = new ArrayList<>();
            pre = res.get(i - 1);
            list.add(1);

            for (int j = 1; j < pre.size(); j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        System.out.println(generate.generate(5));
    }
}
