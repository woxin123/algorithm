package com.example.base.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mengchen
 * @time 18-12-22 下午1:10
 */
public class SelectionSort {

    public static<T> void selectionSort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[] {5, 4, 2, 3, 1, 6};
        System.out.println(Arrays.toString(integers));
        SelectionSort.selectionSort(integers, Integer::compareTo);
        System.out.println(Arrays.toString(integers));
    }
}
