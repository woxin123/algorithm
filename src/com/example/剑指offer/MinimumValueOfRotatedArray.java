package com.example.剑指offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/**
 * 这道题的出题人时怎么想的这样就过了
 * public int minNumberInRotateArray(int [] array) {
 * int min = array[0];
 * for (int i = 0; i < array.length; i++) {
 * if (min > array[i])
 * min = array[i];
 * }
 * return min;
 * }
 */

/**
 * 二分法寻找最小值
 */
public class MinimumValueOfRotatedArray {
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (high > low) {
            int mid = (high + low) / 2;
            if (array[mid] > array[high])
                low = mid + 1;
            else if (array[high] == array[mid])
                high = high - 1;
            else
                high = mid;
        }
        return array[low];
    }
    public static void main(String[] args) {
        MinimumValueOfRotatedArray min = new MinimumValueOfRotatedArray();
        int[] array = {};
        System.out.println(min.minNumberInRotateArray(array));
    }
}
