package com.example.base.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengchen
 * @time 18-12-22 下午12:22
 */
public class BubbleSort {

    /**
     * 冒泡排序只会操作相邻的两个数据，每次冒泡排序操作都会对相邻的两个元素进行比较，看是否满足大小关系。
     * 如果不满足就让它两进行交换。一次冒泡让至少一个元素移动到它应该在的位置，重复n - 1次，就完成了n个数据的排序工作。
     * @param array
     * @param comparator
     * @param <T>
     */
    public static<T> void bubbleSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{5, 3, 2, 1, 4};
        System.out.println(Arrays.toString(integers));
        BubbleSort.bubbleSort(integers, Integer::compareTo);
        System.out.println(Arrays.toString(integers));
    }
}
