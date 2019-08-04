package com.example.leetcode;

/**
 * 只出现一次的数字
 * @author mengchen
 * @time 19-2-20 上午11:20
 */
public class SingleNumber {

    /**
     * 因为 x ^ x = 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }
}
