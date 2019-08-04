package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-1-27 下午5:36
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int tmp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                tmp = 1;
            } else {
                digits[i] += 1;
                tmp = 0;
            }
            if (tmp == 0) {
                break;
            }
        }
        if (tmp == 0) {
            return digits;
        } else {
            int[] ints = new int[digits.length + 1];
            Arrays.fill(ints, 0);
            ints[0] = 1;
            return ints;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9})));
    }
}
