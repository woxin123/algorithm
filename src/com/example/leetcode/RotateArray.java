package com.example.leetcode;

import java.util.Arrays;

/**
 * 旋转数组
 * @author mengchen
 * @time 19-3-10 下午2:23
 */
public class RotateArray {
    static class RotateArrayI {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            reserve(nums, 0, n - 1);
            reserve(nums, 0, k - 1);
            reserve(nums, k, n - 1);
        }

        private void reserve(int[] num, int start, int end) {
            int tmp;
            while (start < end) {
                tmp = num[start];
                num[start++] = num[end];
                num[end--] = tmp;
            }
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};
            new RotateArrayI().rotate(array, 3);
            System.out.println(Arrays.toString(array));
        }
    }

    static class RotateArrayII {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            for (int i = 0; i < nums.length && k != 0; n -= k, i += k, k = k % n) {
                for (int j = 0; j < k; j++) {
                    swap(nums, i + j, nums.length - k + j);
                }
            }

        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }


        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5};
            new RotateArrayII().rotate(array, 3);
            System.out.println(Arrays.toString(array));
        }
    }


}
