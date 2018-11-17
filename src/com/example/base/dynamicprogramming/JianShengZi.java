package com.example.base.dynamicprogramming;

/**
 * 动态规划——剪绳子
 * 剪绳子问题
 * 给你一根长度为N的绳子，请把绳子剪成M段（m,n都是整数），每段绳子的
 * 长度记为k[0],k[1],k[2]…. 请问如何剪绳子使得k[0],k[1],k[2]
 * 的乘积最大
 * @author mengchen
 * @time 18-10-9 上午11:26
 */
public class JianShengZi {

    public static int jianshengzi(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            // 2 * 1
            return 2;
        }

        int[] h = new int[50];
        h[0] = 0;
        h[1] = 1;
        h[2] = 2;
        h[3] = 3;

        for (int i = 4; i <= n; i++) {
            int maxs = 0;
            for (int j = 1; j <= i / 2; j++) {
                int mult = h[j] * h[i - j];
                if (maxs < mult) {
                    maxs = mult;
                }
                h[i] = maxs;
            }
        }
        System.out.println(h[n]);
        return h[n];
    }

    public static void main(String[] args) {
        jianshengzi(5);
    }

}
