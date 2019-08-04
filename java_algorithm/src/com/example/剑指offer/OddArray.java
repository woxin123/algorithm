package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-23
 */

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddArray {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9};
        new OddArray().reOrderArray(array);
    }

    public void reOrderArray(int [] array) {
        int newArray[] = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                newArray[count++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArray[count++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
