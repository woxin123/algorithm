package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-20
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Binary1Number {

    public static void main(String[] args) {
        Binary1Number b = new Binary1Number();

        System.out.println(b.numberOf1(5));
        System.out.println(b.otherNumberOf1(5));
    }

    public int numberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    /**
     * n     = 100100
     * n - 1 = 100011
     * n - 1的二进制从后向前直到第一个1这个位置（包括）与n比起来都会取反
     * @param n
     * @return
     */
    public int otherNumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
