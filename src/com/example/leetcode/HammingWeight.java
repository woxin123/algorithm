package com.example.leetcode;

/**
 * 位1的个数
 * @author mengchen
 * @time 19-3-13 上午9:32
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(3));
    }
}
