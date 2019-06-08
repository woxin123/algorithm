package com.example.剑指offer;

import java.util.Arrays;

/**
 * @author mengchen
 * @time 19-5-5 下午4:23
 */
public class ReOrderArray {

//    static class Solution1 {
//
//        public void reOrderArray(int[] array) {
//            int index = 0;
//
//            for (int i = 0; i < array.length; i++) {
//                if ((array[i] & 1) == 1) {
//                    int temp = array[index];
//                    array[index] = array[i];
//                    array[i] = temp;
//                    index++;
//                }
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] array = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
//            new Solution1().reOrderArray(array);
//            System.out.println(Arrays.toString(array));
//        }
//    }

    static class Solution2 {
        public void reOrderArray(int[] array) {
            int left = 0, right = array.length - 1;

            while (left < right) {
                while (left < right && (array[left] & 1) == 1) {
                    left++;
                }
                while (left < right && (array[right] & 1) == 0) {
                    right--;
                }
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        public static void main(String[] args) {
            int[] array = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
            new Solution2().reOrderArray(array);
            System.out.println(Arrays.toString(array));
        }
    }

}
