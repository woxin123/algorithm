package com.example.剑指offer;

/**
 * 最大连续子序列
 * @author mengchen
 * @time 18-10-9 上午10:13
 */
public class MaxSubListSum {

    public int FindGreatestSumOfSubArray(int[] array) {

        int start = array[array.length - 1];
        int all = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {
            if (start < 0) {
                start = 0;
            }
            start += array[i];
            if (start > all) {
                all = start;
            }
        }
        return all;
    }

}
