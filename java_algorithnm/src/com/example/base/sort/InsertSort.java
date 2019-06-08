package com.example.base.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengchen
 * @time 18-12-22 下午12:36
 */
public class InsertSort {

    /**
     * 首先，将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，
     * 就是数组的第一个元素。插入算法的核心思想是去未排序区间中的元素，在已排序区间中找到合适
     * 的位置插入，并保证已排序的区间数据一直有序。重复这个过程，直到未排序区间中的元素为空。
     * @param array
     * @param comparator
     * @param <T>
     */
    public static<T> void insertSort(T[] array, Comparator<T> comparator) {

        for (int i = 1; i < array.length; i++) {
            T value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (comparator.compare(array[j], value) > 0) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[] {5, 4, 2, 3, 1, 6};
        System.out.println(Arrays.toString(integers));
        InsertSort.insertSort(integers, Integer::compareTo);
        System.out.println(Arrays.toString(integers));
    }

}
