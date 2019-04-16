package com.example.剑指offer;

/**
 * 构建乘积数组
 * @author mengchen
 * @time 19-4-16 下午10:38
 */
public class Multiply {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length > 1) {
            B[0] = 1;
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }

            int temp = 1;
            for (int i = B.length - 2; i >= 0; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }

}
