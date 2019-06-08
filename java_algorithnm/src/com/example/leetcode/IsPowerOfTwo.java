package com.example.leetcode;

/**
 * 2的幂
 * @author mengchen
 * @time 19-3-27 上午9:42
 */
public class IsPowerOfTwo {

    static class Solution1 {

        public boolean isPowerOfTwo(int n) {
            if (n == 0) {
                return false;
            }
            long a = n;
            return (a & (a - 1)) == 0;
        }

        public static void main(String[] args) {
            System.out.println(new Solution1().isPowerOfTwo(15));
        }

    }

}
