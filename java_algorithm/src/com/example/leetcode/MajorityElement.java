package com.example.leetcode;

/**
 * 求众数
 * @author mengchen
 * @time 19-3-5 下午12:20
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i + 1];
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 1, 2, 2, 1, 2, 2}));
    }

}
