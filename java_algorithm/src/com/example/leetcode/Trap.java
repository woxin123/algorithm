package com.example.leetcode;

/**
 * 接雨水
 * @author mengchen
 * @time 18-12-27 上午10:23
 */
public class Trap {
    public int trap(int[] height) {
        int result = 0;
        if (height.length == 0) {
            return 0;
        }
        int lmax = 0, rmax = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax) {
                result += lmax - height[l++];
            } else {
                result += rmax - height[r--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
