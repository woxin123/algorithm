package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-12-30 下午9:40
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[] {1, 3, 4 ,5 , 6})));
    }

}
