package com.example.leetcode;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 18-10-28 下午12:29
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 && nums2.length == 1) {
//            return nums2[0];
//        }
//        if (nums2.length == 0 && nums1.length == 1) {
//            return nums1[0];
//        }
        int length = nums1.length + nums2.length;
        boolean flag = length % 2 == 0;
        int middleIndex = length / 2;
        int[] temp = new int[middleIndex + 2];
        int i = 0, j = 0, count = 0;
        while (count <= middleIndex && i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                temp[count++] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                temp[count++] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                temp[count++] = nums1[i];
                i++;
            } else {
                temp[count++] = nums2[j];
                j++;
            }
        }
        double middle;
        if (flag)
            middle = (temp[middleIndex - 1] + temp[middleIndex]) / 2.0;
        else
            middle = temp[middleIndex];

        return middle;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double medianSortedArrays = findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }


}
