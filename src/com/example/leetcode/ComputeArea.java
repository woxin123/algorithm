package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-4-28 下午7:57
 */
public class ComputeArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.min(C, G) > Math.max(A, E) ? Math.min(C, G) - Math.max(A, E) : 0;
        int y = Math.min(D, H) > Math.max(B, F) ? Math.min(D, H) - Math.max(B, F) : 0;
        return (C - A) * (D - B) - x * y + (G - E) * (H - F);
    }

}
