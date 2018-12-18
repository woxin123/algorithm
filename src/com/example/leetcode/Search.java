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

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[] {4, 5, 6, 7, 0, 1,2 }, 7));
    }
}