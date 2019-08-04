package com.example.leetcode;

/**
 * 阶乘后的零
 * @author mengchen
 * @time 19-3-6 上午9:20
 */
public class TrailingZeroes {

    /**
     * 寻找n中5倍数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().trailingZeroes(5));
    }

}
