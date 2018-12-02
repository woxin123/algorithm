package com.example.leetcode;

/**
 * @author mengchen
 * @time 18-12-2 下午2:38
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] cha = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            cha[i] = A[i + 1] - A[i];
        }
        int count = 0;
        int x = 1;
        for (int i = 0; i < cha.length - 1; i++) {
            if (cha[i] == cha[i + 1]) {
                count += x;
                x++;
            } else {
                x = 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }
}
