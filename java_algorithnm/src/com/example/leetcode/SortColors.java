package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-1-29 上午11:25
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int redNum = 0;
        int whiteNum = 0;
        int blueNum = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    redNum++;
                    break;
                case 1:
                    whiteNum++;
                    break;
                case 2:
                    blueNum++;
                    break;
                default:
                    return;
            }
        }
        int count = 0;
        while (redNum-- > 0) {
            nums[count++] = 0;
        }
        while (whiteNum-- > 0) {
            nums[count++] = 1;
        }
        while (blueNum-- > 0) {
            nums[count++] = 2;
        }
    }

    /**
     * 双指针法
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;

        while (i < right) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                ++left;
                ++i;
            } else if (nums[i] == 1) {
                i++;
            } else if (i <= right && nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                --right;
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1, 0, 2, 2, 1, 0};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
