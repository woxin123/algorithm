package com.example.leetcode;

import java.util.Arrays;

/**
 * 最大数
 * @author mengchen
 * @time 19-3-7 下午5:36
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (s1, s2)->
            (s2 + s1).compareTo(s1 + s2));
        if (strs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }
}
