package com.example.leetcode;

/**
 * @author mengchen
 * @time 19-2-1 下午3:16
 */
public class RemoveDuplicatesII {

    /**
     * 双指针法，把重复的移动到后面去
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesII().removeDuplicates(new int[]{1, 1, 1, 2, 3, 3, 3, 4}));
    }

}
