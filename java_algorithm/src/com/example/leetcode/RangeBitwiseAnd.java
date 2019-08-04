package com.example.leetcode;

/**
 * 数字范围按位与
 * @author mengchen
 * @time 19-3-17 下午2:24
 */
public class RangeBitwiseAnd {

    /**
     * 与的特点 1 1 为 1 其他都为0
     * 所以一旦二进制中出现0，那么这一位便为0了
     * 所以只需要n和m二进制前面相同的部分，其他的都可能为0
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (n != m && m != 0) {
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return m << count;
    }

}
