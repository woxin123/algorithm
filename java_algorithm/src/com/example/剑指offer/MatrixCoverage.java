package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-19
 */

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 解题思路：详见：https://uploadfiles.nowcoder.net/images/20170718/3614591_1500381257269_B18DB55610F4CC5E67C96674FE51EBDC
 */
public class MatrixCoverage {
    public static void main(String[] args) {
        MatrixCoverage m = new MatrixCoverage();
        int result = m.soluation(3);
        System.out.println(result);
    }

    private int soluation(int number) {
        int i = 1, j = 2, temp;
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        } else {
            for (int x = 3; x <= number; x++) {
                temp = i;
                i = j;
                j = temp + j;
            }
            return j;
        }
    }
}
