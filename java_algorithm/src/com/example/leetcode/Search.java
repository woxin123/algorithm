package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author mengchen
 * @time 18-12-18 上午10:30
 */
public class Search {
    public int search(int[] nums, int target) {
        int x = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                x = i + 1;
            }
        }
        int i = binarySearch(nums, 0, x -1, target);
        if (i > -1) {
            return i;
        }
        int i1 = binarySearch(nums, x, nums.length - 1, target);
        if (i1 > -1) {
            return i1;
        }
        return -1;
    }

    int binarySearch(int nums[], int start, int end, int target) {
        int middle;

        while (start <= end) {
            middle = (start + end) >>> 1;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target){
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {    // 3 4 5 1 2 nums[mid] = 5 target 4
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search1(new int[] {4, 5, 6, 7, 0, 1,2 }, 7));
    }
}
