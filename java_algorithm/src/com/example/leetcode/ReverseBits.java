package com.example.leetcode;

/**
 * 颠倒二进制位
 * @author mengchen
 * @time 19-3-12 上午9:22
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // res左移一位
            res <<= 1;
            // 和n求和
            res += n & 1;
            // n右移一位
            n >>= 1;
        }
        return res;
    }

}
