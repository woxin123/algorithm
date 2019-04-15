package com.example.剑指offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * @author mengchen
 * @time 19-4-14 下午10:57
 */
public class NumberOf1 {

    static class Solution1 {
        public int NumberOf1(int n) {
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }

                n = n >>> 1;
            }

            return count;
        }
    }

    /**
     *  把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0。
     *  假如最右边一位是1，那么减一后为0，做与运算1 0 -> 0，加入1101  1101 & 1100 = 1100
     *  假如最右边一位是0，然后减一的话，它会把最右边的一个1变成0，从这位开始，右边的位全部变成1，例如 1100  1100 - 1 = 1001，1100 & 1001 = 1000
     */
    static class Solution2 {
        public int NumberOf1(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int a = 0x80000000;
        System.out.println(a >> 1);
    }
}
