package com.example.leetcode;

/**
 * 跳跃游戏
 * @auther 孟晨
 * @date 2019/1/21 12:21
 */
public class CanJump {
    /**
     * dfs 超时了
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int [] nums, int step) {
        if (step >= nums.length) {
            return false;
        }
        if (step == nums.length - 1) {
            return true;
        }
        boolean canJump = false;
        for (int i = 1; i <= nums[step]; i++) {
            if (dfs(nums, step + i)) {
                canJump = true;
                break;
            }
        }
        return canJump;
    }

    /**
     * 没理解
     * 从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。否则继续往前，弱最后剩下的元素大于1个，
     * 则可以判断为假。否则就是真
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump3(int[] nums) {
        int pre = 0, current;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(pre, nums[i - 1]) - 1;
            if (current < 0) {
                return false;
            }
            pre = current;
        }
        return true;
    }

    /**
     * 我们并不是很关心每一个位置上的剩余步数，
     * 我们只希望知道能否到达末尾，
     * 也就是说我们只对最远能到达的位置感兴趣，
     * 所以我们维护一个变量reach，表示最远能到达的位置，
     * 初始化为0。遍历数组中每一个数字，
     * 如果当前坐标大于reach或者reach已经抵达最后一个位置则跳出循环，
     * 否则就更新reach的值为其和i + nums[i]中的较大值，
     * 其中i + nums[i]表示当前位置能到达的最大位置，
     * @param nums
     * @return
     */
    public boolean canJump4(int[] nums) {
        int len = nums.length;
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach || reach >= len - 1) {
                break;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= len - 1;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump2(new int[] {2, 3, 1, 1, 4}));
    }
}
