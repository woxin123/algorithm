package com.example.leetcode;

/**
 * 只出现一次的数字 II
 * @author mengchen
 * @time 19-2-20 上午11:22
 */
public class SingleNumberII {

    /**
     * 模三运算
     *
     * x ^ 0 = 0
     * x ^ x = 0
     *
     * ab ^ 00 = 0
     * ab ^ ab = 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            // x 0
            a = (a ^ x) & ~b;
            // 0 x
            b = (b ^ x) & ~a;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{10,10,10,1,4,4,4,5,5,5}));
    }
}
