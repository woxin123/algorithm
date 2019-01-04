package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-1-4 下午10:00
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        grayCodeHelp(result, 0, 0, n);
        return result;
    }

    public void grayCodeHelp(List<Integer> list, int index, int num, int n) {
        for (int i = index; i < 1 << n; i++) {
            num = i ^ (i >> 1);
            list.add(num);
        }
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }
}
